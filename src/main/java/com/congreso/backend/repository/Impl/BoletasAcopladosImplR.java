package com.congreso.backend.repository.Impl;

import com.congreso.backend.entities.BoletasAcopladosE;
import com.congreso.backend.libs.FormatoNumeros;
import com.congreso.backend.libs.ObtenerFechas;
import com.congreso.backend.model.BoletasAcoplados;
import com.congreso.backend.model.dto.MacopladosDto;
import com.congreso.backend.repository.BoletasAcopladosR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@RequiredArgsConstructor
@Repository
public class BoletasAcopladosImplR implements BoletasAcopladosR {
    private final JdbcTemplate db;
    private String sql;
    @Override
    public void save_boletasAcoplados(long id_daco,LocalDate xfecha, float xmonto, BoletasAcopladosE bol) {
        sql = " INSERT INTO boletas_acoplados(id_daco,mes,anio,gestion,monto,creado_por) "+
              "   values(?,?,?,?,?,?) ";
        db.update(sql,id_daco,bol.getMes(),bol.getAnio(),bol.getGestion(),determinarMontoBoletas(xmonto,xfecha),bol.getCreado_por());
    }
    public float determinarMontoBoletas(float xmonto, LocalDate xfechaini){
        float monto=xmonto;
        float montoXdia=monto / ObtenerFechas.getDiasDelMes(xfechaini);
        int diasApagar = ObtenerFechas.getDiasDelMes(xfechaini) - ObtenerFechas.getDay(xfechaini);
        return FormatoNumeros.getNumber(montoXdia * diasApagar, 2);
    }




}
