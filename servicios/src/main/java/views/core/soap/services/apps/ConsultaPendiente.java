/**
 * ConsultaPendiente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package views.core.soap.services.apps;

public class ConsultaPendiente  implements java.io.Serializable {
    private java.lang.String xml;

    private java.lang.String estatus;

    private java.lang.String uuid;

    private java.lang.String sig_intento;

    private java.lang.String fecha;

    private java.lang.String uuid_estatus;

    private java.lang.String intentos;

    private java.lang.String error;

    public ConsultaPendiente() {
    }

    public ConsultaPendiente(
           java.lang.String xml,
           java.lang.String estatus,
           java.lang.String uuid,
           java.lang.String sig_intento,
           java.lang.String fecha,
           java.lang.String uuid_estatus,
           java.lang.String intentos,
           java.lang.String error) {
           this.xml = xml;
           this.estatus = estatus;
           this.uuid = uuid;
           this.sig_intento = sig_intento;
           this.fecha = fecha;
           this.uuid_estatus = uuid_estatus;
           this.intentos = intentos;
           this.error = error;
    }


    /**
     * Gets the xml value for this ConsultaPendiente.
     * 
     * @return xml
     */
    public java.lang.String getXml() {
        return xml;
    }


    /**
     * Sets the xml value for this ConsultaPendiente.
     * 
     * @param xml
     */
    public void setXml(java.lang.String xml) {
        this.xml = xml;
    }


    /**
     * Gets the estatus value for this ConsultaPendiente.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this ConsultaPendiente.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the uuid value for this ConsultaPendiente.
     * 
     * @return uuid
     */
    public java.lang.String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value for this ConsultaPendiente.
     * 
     * @param uuid
     */
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
    }


    /**
     * Gets the sig_intento value for this ConsultaPendiente.
     * 
     * @return sig_intento
     */
    public java.lang.String getSig_intento() {
        return sig_intento;
    }


    /**
     * Sets the sig_intento value for this ConsultaPendiente.
     * 
     * @param sig_intento
     */
    public void setSig_intento(java.lang.String sig_intento) {
        this.sig_intento = sig_intento;
    }


    /**
     * Gets the fecha value for this ConsultaPendiente.
     * 
     * @return fecha
     */
    public java.lang.String getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this ConsultaPendiente.
     * 
     * @param fecha
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the uuid_estatus value for this ConsultaPendiente.
     * 
     * @return uuid_estatus
     */
    public java.lang.String getUuid_estatus() {
        return uuid_estatus;
    }


    /**
     * Sets the uuid_estatus value for this ConsultaPendiente.
     * 
     * @param uuid_estatus
     */
    public void setUuid_estatus(java.lang.String uuid_estatus) {
        this.uuid_estatus = uuid_estatus;
    }


    /**
     * Gets the intentos value for this ConsultaPendiente.
     * 
     * @return intentos
     */
    public java.lang.String getIntentos() {
        return intentos;
    }


    /**
     * Sets the intentos value for this ConsultaPendiente.
     * 
     * @param intentos
     */
    public void setIntentos(java.lang.String intentos) {
        this.intentos = intentos;
    }


    /**
     * Gets the error value for this ConsultaPendiente.
     * 
     * @return error
     */
    public java.lang.String getError() {
        return error;
    }


    /**
     * Sets the error value for this ConsultaPendiente.
     * 
     * @param error
     */
    public void setError(java.lang.String error) {
        this.error = error;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaPendiente)) return false;
        ConsultaPendiente other = (ConsultaPendiente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.xml==null && other.getXml()==null) || 
             (this.xml!=null &&
              this.xml.equals(other.getXml()))) &&
            ((this.estatus==null && other.getEstatus()==null) || 
             (this.estatus!=null &&
              this.estatus.equals(other.getEstatus()))) &&
            ((this.uuid==null && other.getUuid()==null) || 
             (this.uuid!=null &&
              this.uuid.equals(other.getUuid()))) &&
            ((this.sig_intento==null && other.getSig_intento()==null) || 
             (this.sig_intento!=null &&
              this.sig_intento.equals(other.getSig_intento()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.uuid_estatus==null && other.getUuid_estatus()==null) || 
             (this.uuid_estatus!=null &&
              this.uuid_estatus.equals(other.getUuid_estatus()))) &&
            ((this.intentos==null && other.getIntentos()==null) || 
             (this.intentos!=null &&
              this.intentos.equals(other.getIntentos()))) &&
            ((this.error==null && other.getError()==null) || 
             (this.error!=null &&
              this.error.equals(other.getError())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getXml() != null) {
            _hashCode += getXml().hashCode();
        }
        if (getEstatus() != null) {
            _hashCode += getEstatus().hashCode();
        }
        if (getUuid() != null) {
            _hashCode += getUuid().hashCode();
        }
        if (getSig_intento() != null) {
            _hashCode += getSig_intento().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getUuid_estatus() != null) {
            _hashCode += getUuid_estatus().hashCode();
        }
        if (getIntentos() != null) {
            _hashCode += getIntentos().hashCode();
        }
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaPendiente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("apps.services.soap.core.views", "ConsultaPendiente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xml");
        elemField.setXmlName(new javax.xml.namespace.QName("apps.services.soap.core.views", "xml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatus");
        elemField.setXmlName(new javax.xml.namespace.QName("apps.services.soap.core.views", "estatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uuid");
        elemField.setXmlName(new javax.xml.namespace.QName("apps.services.soap.core.views", "uuid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sig_intento");
        elemField.setXmlName(new javax.xml.namespace.QName("apps.services.soap.core.views", "sig_intento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("apps.services.soap.core.views", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uuid_estatus");
        elemField.setXmlName(new javax.xml.namespace.QName("apps.services.soap.core.views", "uuid_estatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intentos");
        elemField.setXmlName(new javax.xml.namespace.QName("apps.services.soap.core.views", "intentos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("apps.services.soap.core.views", "error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
