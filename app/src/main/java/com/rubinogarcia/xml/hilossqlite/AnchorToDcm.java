package com.rubinogarcia.xml.hilossqlite;

/**
 * Created by marco on 18/07/2015.
 */
public class AnchorToDcm {

    private  String anchor, dcm;


    //1 Constructor predeterminado
    public AnchorToDcm() {
        this("", "");

    }

    //2 Constructor completo
    public AnchorToDcm( String anchor, String dcm) {
        this.anchor = anchor;
        this.dcm = dcm;
    }


    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public String getDcm() {
        return dcm;
    }

    public void setDcm(String dcm) {
        this.dcm = dcm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnchorToDcm that = (AnchorToDcm) o;

        if (anchor != null ? !anchor.equals(that.anchor) : that.anchor != null) return false;
        return !(dcm != null ? !dcm.equals(that.dcm) : that.dcm != null);

    }

    @Override
    public int hashCode() {
        int result = anchor != null ? anchor.hashCode() : 0;
        result = 31 * result + (dcm != null ? dcm.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "AnchorToDcm{" +
                "anchor='" + anchor + '\'' +
                ", dcm='" + dcm + '\'' +
                '}';
    }
}
