/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.EnumMap;
import java.util.concurrent.LinkedBlockingQueue;

import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.DPFPCapturePriority;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPDataListener;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;

import java.util.List;
import javax.swing.JOptionPane;
import monitor.Monitor;

public class LeitorBiometrico {

    public static final EnumMap<DPFPFingerIndex, String> fingerNames;
    int contador = 0;

    static {
        fingerNames = new EnumMap<DPFPFingerIndex, String>(DPFPFingerIndex.class);
        fingerNames.put(DPFPFingerIndex.LEFT_PINKY, "left pinky");
        fingerNames.put(DPFPFingerIndex.LEFT_RING, "left ring");
        fingerNames.put(DPFPFingerIndex.LEFT_MIDDLE, "left middle");
        fingerNames.put(DPFPFingerIndex.LEFT_INDEX, "left index");
        fingerNames.put(DPFPFingerIndex.LEFT_THUMB, "left thumb");
        fingerNames.put(DPFPFingerIndex.RIGHT_PINKY, "right pinky");
        fingerNames.put(DPFPFingerIndex.RIGHT_RING, "right ring");
        fingerNames.put(DPFPFingerIndex.RIGHT_MIDDLE, "right middle");
        fingerNames.put(DPFPFingerIndex.RIGHT_INDEX, "right index");
        fingerNames.put(DPFPFingerIndex.RIGHT_THUMB, "right thumb");
    }

    public DPFPTemplate getTemplate(String activeReader, int nFinger) {
        System.out.printf("Performing fingerprint enrollment...\n");

        DPFPTemplate template = null;

        try {
            DPFPFingerIndex finger = DPFPFingerIndex.values()[nFinger];
            DPFPFeatureExtraction featureExtractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
            DPFPEnrollment enrollment = DPFPGlobal.getEnrollmentFactory().createEnrollment();
            while (enrollment.getFeaturesNeeded() > 0) {

                DPFPSample sample = getSample(activeReader,
                        String.format("Scan your %s finger (%d remaining)\n", fingerName(finger), enrollment.getFeaturesNeeded()));
                contador++;
                JOptionPane.showMessageDialog(null, "Digital capturada! Repita o processo novamente. " + contador + "/4");
                if (sample == null) {
                    continue;
                }

                DPFPFeatureSet featureSet;
                try {
                    featureSet = featureExtractor.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
                } catch (DPFPImageQualityException e) {
                    System.out.printf("Bad image quality: \"%s\". Try again. \n", e.getCaptureFeedback().toString());
                    continue;
                }

                enrollment.addFeatures(featureSet);
            }
            template = enrollment.getTemplate();
            System.out.printf("The %s was enrolled.\n", fingerprintName(finger));
            JOptionPane.showMessageDialog(null, "Digital capturada com sucesso !");
            contador = 0;
        } catch (DPFPImageQualityException e) {
            System.out.printf("Failed to enroll the finger.\n");
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a digital! \n\nRepita o processo novamente!",
                    "Digitais não conferem", JOptionPane.ERROR_MESSAGE);
            contador = 0;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return template;
    }

    public DPFPSample getSample(String activeReader, String prompt)
            throws InterruptedException {
        final LinkedBlockingQueue<DPFPSample> samples = new LinkedBlockingQueue<DPFPSample>();
        DPFPCapture capture = DPFPGlobal.getCaptureFactory().createCapture();
        capture.setReaderSerialNumber(activeReader);
        capture.setPriority(DPFPCapturePriority.CAPTURE_PRIORITY_LOW);
        capture.addDataListener(new DPFPDataListener() {
            public void dataAcquired(DPFPDataEvent e) {
                if (e != null && e.getSample() != null) {
                    try {
                        samples.put(e.getSample());
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        capture.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            int lastStatus = DPFPReaderStatusEvent.READER_CONNECTED;

            public void readerConnected(DPFPReaderStatusEvent e) {
                if (lastStatus != e.getReaderStatus()) {
                    System.out.println("Reader is connected");
                }
                lastStatus = e.getReaderStatus();
            }

            public void readerDisconnected(DPFPReaderStatusEvent e) {
                if (lastStatus != e.getReaderStatus()) {
                    System.out.println("Reader is disconnected");
                }
                lastStatus = e.getReaderStatus();
            }

        });
        try {
            capture.startCapture();
            System.out.print(prompt);
            return samples.take();
        } catch (RuntimeException e) {
            System.out.printf("Failed to start capture. Check that reader is not used by another application.\n");
            throw e;
        } finally {
            capture.stopCapture();
        }
    }

    public boolean verify(String activeReader, DPFPTemplate template) {
        try {
            DPFPSample sample = getSample(activeReader, "Scan your finger\n");
            if (sample == null) {
                throw new Exception();
            }
            DPFPFeatureExtraction featureExtractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
            DPFPFeatureSet featureSet = featureExtractor.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
            DPFPVerification matcher = DPFPGlobal.getVerificationFactory().createVerification();
            matcher.setFARRequested(DPFPVerification.MEDIUM_SECURITY_FAR);

            for (DPFPFingerIndex finger : DPFPFingerIndex.values()) {
                //DPFPTemplate template = user.getTemplate(finger); 
                if (template != null) {
                    DPFPVerificationResult result = matcher.verify(featureSet, template);
                    if (result.isVerified()) {
                        System.out.printf("Matching finger: %s, FAR achieved: %g.\n",
                                fingerName(finger), (double) result.getFalseAcceptRate() / DPFPVerification.PROBABILITY_ONE);
                        return result.isVerified();
                    }
                }
            }
        } catch (Exception e) {
            System.out.printf("Failed to perform verification.");
        }

        return false;
    }

    public Monitor verificarSeCadastrado(String activeReader, List<Monitor> monitores) {
        DPFPTemplate templateMaoDireita = DPFPGlobal.getTemplateFactory().createTemplate();
        DPFPTemplate templateMaoEsquerda = DPFPGlobal.getTemplateFactory().createTemplate();
        try {
            DPFPSample sample = getSample(activeReader, "Scan your finger\n");
            if (sample == null) {
                throw new Exception();
            }
            DPFPFeatureExtraction featureExtractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
            DPFPFeatureSet featureSet = featureExtractor.createFeatureSet(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
            DPFPVerification matcher = DPFPGlobal.getVerificationFactory().createVerification();
            matcher.setFARRequested(DPFPVerification.MEDIUM_SECURITY_FAR);

            for (DPFPFingerIndex finger : DPFPFingerIndex.values()) {

                if (templateMaoDireita != null && templateMaoEsquerda != null) {
                    for (int i = 0; i < monitores.size(); i++) {
                        try {
                            templateMaoDireita.deserialize(monitores.get(i).getDigitalDireita());
                            templateMaoEsquerda.deserialize(monitores.get(i).getDigitalEsquerda());
                            DPFPVerificationResult resultMaoDireita = matcher.verify(featureSet, templateMaoDireita);
                            DPFPVerificationResult resultMaoEsquerda = matcher.verify(featureSet, templateMaoEsquerda);
                            if (resultMaoDireita.isVerified()) {
                                System.out.printf("Matching finger: %s, FAR achieved: %g.\n",
                                        fingerName(finger), (double) resultMaoDireita.getFalseAcceptRate() / DPFPVerification.PROBABILITY_ONE);
                                return monitores.get(i);
                            } else if (resultMaoEsquerda.isVerified()) {
                                System.out.printf("Matching finger: %s, FAR achieved: %g.\n",
                                        fingerName(finger), (double) resultMaoEsquerda.getFalseAcceptRate() / DPFPVerification.PROBABILITY_ONE);
                                return monitores.get(i);
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.printf("Failed to perform verification.");
        }

        return null;
    }

    public String fingerName(DPFPFingerIndex finger) {
        return fingerNames.get(finger);
    }

    public String fingerprintName(DPFPFingerIndex finger) {
        return fingerNames.get(finger) + " fingerprint";
    }
}
