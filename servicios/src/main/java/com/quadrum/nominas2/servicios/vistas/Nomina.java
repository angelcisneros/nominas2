package com.quadrum.nominas2.servicios.vistas;

import com.quadrum.nominas2.entidades.Archivo;
import com.quadrum.nominas2.entidades.Domicilio;
import com.quadrum.nominas2.entidades.Empleado;
import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.entidades.InformacionOpcional;
import com.quadrum.nominas2.entidades.Recibo;
import com.quadrum.nominas2.entidades.RegimenContratacion;
import com.quadrum.nominas2.entidades.RiesgoPuesto;
import com.quadrum.nominas2.entidades.Sucursal;
import static com.quadrum.nominas2.servicios.util.Utileria.convierteImporte;
import static com.quadrum.nominas2.servicios.util.Utileria.convierteStringToFecha;
import static com.quadrum.nominas2.servicios.util.Utileria.formatoFecha;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Nomina implements Serializable {

    @NotNull(message = "Obligatorios:Debe de contener campos obligatorios")
    @Valid @Getter @Setter private Obligatorios obligatorios;
    @NotNull(message = "Sucursal:Debe de contener una sucursal")
    @Valid @Getter @Setter private Sucursal sucursal;
    @Valid @Getter @Setter private Opcionales opcionales;
    @Valid @Getter @Setter private Percepciones percepciones;
    @Valid @Getter @Setter private Deducciones deducciones;
    @Getter @Setter private Recibo recibo;
    @Getter @Setter private Empresa empresa;
    @Getter @Setter private Domicilio domicilio;
    @Getter @Setter private Map<String, Object> parametros;
    @Getter @Setter private Respuesta respuesta;
    @NotNull(message = "Archivo:Debe de contener una sucursal")
    @Valid @Getter @Setter private Archivo archivo;

    
    public Recibo parsearNomina(Empresa empresa, Sucursal sucursal, Domicilio domicilio) {
        this.empresa = empresa;
        this.sucursal = sucursal;
        this.domicilio = domicilio;
        crearRecibo();
        return this.recibo;
    }

    private void crearRecibo() {
        recibo = new Recibo();
        recibo.setArchivo(archivo);
        recibo.setEmpleado(crearEmpleado());
        recibo.setFechaFinalPago(convierteStringToFecha(obligatorios.getFechaFinalPago()));
        recibo.setFechaInicialPago(convierteStringToFecha(obligatorios.getFechaInicialPago()));
        recibo.setFehcaPago(convierteStringToFecha(obligatorios.getFechaPago()));
        recibo.setInformacionOpcional(crearInformacionOpcional());
        recibo.setNumEmpleado(obligatorios.getNumEmpleado());
        recibo.setNumeroDiasPagados(parseInt(obligatorios.getNumeroDiasPagados()));
        recibo.setPeriodicidadPago(obligatorios.getPeriocidadPago());
        recibo.setRegimenContratacion(new RegimenContratacion(parseInt(obligatorios.getRegimenContratacion())));
        recibo.setSucursal(sucursal);
        recibo.setTotalPagar(new BigDecimal(obligatorios.getTotalPagar()));
        obligatorios.setFechaPago(formatoFecha(obligatorios.getFechaPago()));
        obligatorios.setFechaInicialPago(formatoFecha(obligatorios.getFechaInicialPago()));
        obligatorios.setFechaFinalPago(formatoFecha(obligatorios.getFechaFinalPago()));
    }

    private InformacionOpcional crearInformacionOpcional() {
        if (opcionales == null) {
            return null;
        }
        
        InformacionOpcional informacionOpcional = new InformacionOpcional();
        informacionOpcional.setClabe(opcionales.getClabe());
        informacionOpcional.setDepartamento(opcionales.getDepartamento());
        informacionOpcional.setPuesto(opcionales.getPuesto());
        informacionOpcional.setTipoContrato(opcionales.getTipoContrato());
        informacionOpcional.setTipoJornada(opcionales.getTipoJornada());
        if (opcionales.getAntiguedad() != null) {
            informacionOpcional.setAntiguedad(parseInt(opcionales.getAntiguedad()));
        }
        if (opcionales.getFechaInicoLaboral() != null) {
            informacionOpcional.setFechaInicoLaboral(convierteStringToFecha(opcionales.getFechaInicoLaboral()));
            opcionales.setFechaInicoLaboral(formatoFecha(opcionales.getFechaInicoLaboral()));
        }
        if (opcionales.getFechaInicoLaboral() != null) {
            informacionOpcional.setFechaInicoLaboral(convierteStringToFecha(opcionales.getFechaInicoLaboral()));
        }
        if (opcionales.getRiesgoPuesto() != null) {
            informacionOpcional.setRiesgoPuesto(new RiesgoPuesto(parseInt(opcionales.getRiesgoPuesto())));
        }
        if (opcionales.getSalarioBase() != null) {
            informacionOpcional.setSalarioBase(new BigDecimal(opcionales.getSalarioBase()));
            opcionales.setSalarioBase(convierteImporte(opcionales.getSalarioBase()));
        }
        if (opcionales.getSalarioDiario() != null) {
            informacionOpcional.setSalarioDiario(new BigDecimal(opcionales.getSalarioDiario()));
            opcionales.setSalarioDiario(convierteImporte(opcionales.getSalarioDiario()));
        }
        crearTotales();
        return informacionOpcional;
    }
    private void crearTotales(){
        if(percepciones != null){
            percepciones.setTotalExento(convierteImporte(percepciones.getTotalExento()));
            percepciones.setTotalGravado(convierteImporte(percepciones.getTotalGravado()));
        }
        if(deducciones != null){
            deducciones.setTotalExento(convierteImporte(deducciones.getTotalExento()));
            deducciones.setTotalGravado(convierteImporte(deducciones.getTotalGravado()));
        }
    }
    private Empleado crearEmpleado() {
        Empleado empleado = new Empleado();
        empleado.setCurp(obligatorios.getCurp());
        empleado.setRfc(obligatorios.getRfc());
        empleado.setNombre(obligatorios.getNombre());
        return empleado;
    }
}
