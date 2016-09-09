package org.verapdf.model.factory.operators;

import org.verapdf.cos.COSObject;
import org.verapdf.model.impl.pd.colors.GFPDColorSpace;
import org.verapdf.model.impl.pd.font.GFPDFont;
import org.verapdf.model.impl.pd.images.GFPDXObject;
import org.verapdf.pd.PDExtGState;

/**
 * @author Maksim Bezrukov
 */
public class TransparencyGraphicsState {

    // fields for transparency checks
    private COSObject sMask = null;
    private float ca = 1;
    private float ca_ns = 1;
    private COSObject bm = null;

    // fields for transparency checks. This is veraPDF implementation of XObject
    private GFPDXObject veraXObject = null;
    private GFPDColorSpace veraFillColorSpace = null;
    private GFPDColorSpace veraStrokeColorSpace = null;
    private GFPDFont veraFont = null;
    private byte[] charCodes = null;

    public COSObject getSMask() {
        return sMask;
    }

    public void setSMask(COSObject sMask) {
        this.sMask = sMask;
    }

    public float getCa() {
        return ca;
    }

    public void setCa(float ca) {
        this.ca = ca;
    }

    public float getCa_ns() {
        return ca_ns;
    }

    public void setCa_ns(float ca_ns) {
        this.ca_ns = ca_ns;
    }

    public COSObject getBm() {
        return bm;
    }

    public void setBm(COSObject bm) {
        this.bm = bm;
    }

    public GFPDXObject getVeraXObject() {
        return veraXObject;
    }

    public void setVeraXObject(GFPDXObject veraXObject) {
        this.veraXObject = veraXObject;
    }

    public GFPDColorSpace getVeraFillColorSpace() {
        return veraFillColorSpace;
    }

    public void setVeraFillColorSpace(GFPDColorSpace veraFillColorSpace) {
        this.veraFillColorSpace = veraFillColorSpace;
    }

    public GFPDColorSpace getVeraStrokeColorSpace() {
        return veraStrokeColorSpace;
    }

    public void setVeraStrokeColorSpace(GFPDColorSpace veraStrokeColorSpace) {
        this.veraStrokeColorSpace = veraStrokeColorSpace;
    }

    public GFPDFont getVeraFont() {
        return veraFont;
    }

    public void setVeraFont(GFPDFont veraFont) {
        this.veraFont = veraFont;
    }

    public byte[] getCharCodes() {
        return charCodes;
    }

    public void setCharCodes(byte[] charCodes) {
        this.charCodes = charCodes;
    }

    public void copyProperties(TransparencyGraphicsState graphicState) {
        this.sMask = graphicState.getSMask();
        this.ca_ns = graphicState.getCa_ns();
        this.ca = graphicState.getCa();
        this.bm = graphicState.getBm();
        this.veraXObject = graphicState.getVeraXObject();
        this.veraFillColorSpace = graphicState.getVeraFillColorSpace();
        this.veraStrokeColorSpace = graphicState.getVeraStrokeColorSpace();
        this.veraFont = graphicState.getVeraFont();
        this.charCodes = graphicState.getCharCodes();
    }

    public void copyPropertiesFormExtGState(PDExtGState extGState) {
        if (extGState != null) {
            COSObject smask = extGState.getCOSSMask();
            if (smask != null) {
                this.sMask = smask;
            }
            COSObject bm = extGState.getCOSBM();
            if (bm != null) {
                this.bm = bm;
            }
            Double ca_ns = extGState.getCA_NS();
            if (ca_ns != null) {
                this.ca_ns = ca_ns.floatValue();
            }
            Double ca = extGState.getCA();
            if (ca != null) {
                this.ca = ca.floatValue();
            }
        }
    }

    @Override
    protected TransparencyGraphicsState clone() {
        TransparencyGraphicsState clone = new TransparencyGraphicsState();
        clone.sMask = this.sMask;
        clone.ca_ns = this.ca_ns;
        clone.ca = this.ca;
        clone.bm = this.bm;
        clone.veraXObject = this.veraXObject;
        clone.veraFillColorSpace = this.veraFillColorSpace;
        clone.veraStrokeColorSpace = this.veraStrokeColorSpace;
        clone.veraFont = this.veraFont;
        clone.charCodes = this.charCodes;
        return clone;
    }
}
