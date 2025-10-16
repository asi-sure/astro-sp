package com.congreso.backend.repository.Impl;

import com.congreso.backend.libs.FormatoNumeros;
import com.congreso.backend.libs.ObtenerFechas;
import com.congreso.backend.model.BoletasContratos;
import com.congreso.backend.model.Dcontratos;
import com.congreso.backend.repository.BoletasContratosR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoletasContratosImplR implements BoletasContratosR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public void save_boletasContratos(Dcontratos det, BoletasContratos bol, LocalDate xfechaini){
        sql = " INSERT INTO boletas_contratos(id_dcon,mes,anio,gestion,monto,creado_por) "+
              "   values(?,?,?,?,?,?) ";
        if (det.getPrincipal()==1){
db.update(sql, det.getId_dcon(),bol.getMes(),bol.getAnio(),bol.getGestion(),determinarMontoBoletas(det.getImporte(),xfechaini),bol.getCreado_por());
        }else{
db.update(sql, det.getId_dcon(),bol.getMes(),bol.getAnio(),bol.getGestion(),0,bol.getCreado_por());
        }
    }

    public float determinarMontoBoletas(float xmonto, LocalDate xfechaini){
        float monto=xmonto;
        float montoXdia=monto / ObtenerFechas.getDiasDelMes(xfechaini);
        int diasApagar = ObtenerFechas.getDiasDelMes(xfechaini) - ObtenerFechas.getDay(xfechaini);
        return FormatoNumeros.getNumber(montoXdia * diasApagar, 2);
    }

}
