<?php
class p220{
    var $a_server,$a_user,$a_password,$a_database,$a_conection,$a_queryResult;
    function m_getData(){
        $this->a_server=trim(fgets(STDIN));
        $this->a_user=trim(fgets(STDIN));
        $this->a_password=trim(fgets(STDIN));
        $this->a_database=trim(fgets(STDIN));
    }
    function m_open(){
        $this->a_conection = mysqli_connect($this->a_server,$this->a_user,$this->a_password,$this->a_database);
    }
    function m_query(){
        $v_query="select concat(u.Apellidos,' ', u.Nombre) as nombre_completo, s.Nombre as servicio, round(f.Monto,2) as Monto, f.fecha_Vencimiento from BD_PagoServ_Facturas f join Usuarios u on f.id_Cliente = u.Usuario
                  join BD_PagoServ_Servicios s on f.id_Servicio = s.id 
                  where f.fecha_Vencimiento <= '2019-01-20' and (f.fecha_Pago = '0000-00-00' or f.fecha_Pago is null)
                  order by nombre_completo asc, f.fecha_Vencimiento asc;";
        $this->a_queryResult=mysqli_query($this->a_conection,$v_query);
    }
    function m_getPayments(){
        $v_totalDebt = 0;
        $v_clients = array();
        while($v_row = mysqli_fetch_assoc($this->a_queryResult)){
            $v_totalDebt += $v_row['Monto'];
            $v_clients[$v_row['nombre_completo']][] =
                array('servicio' => $v_row['servicio'], 'monto' => $v_row['Monto'],
                      'fecha_vencimiento' => $v_row['fecha_Vencimiento']);
        }
        echo "Total de Adeudos: $".number_format($v_totalDebt,2).PHP_EOL;
        foreach($v_clients as $v_client => $v_services) {
            $v_clientDebt = array_sum(array_column($v_services, 'monto'));
            echo "Cliente: $v_client Total de Adeudo: $".number_format($v_clientDebt,2).PHP_EOL;
            foreach ($v_services as $v_service)
                echo "Servicio: ".$v_service['servicio']." Total: $".number_format($v_service['monto'],2)." Fecha Venc.: ".$v_service['fecha_vencimiento'].PHP_EOL;
        }
    }

    function m_close(){mysqli_close($this->a_conection);}
    function m_showResults(){
        $this->m_getData();
        $this->m_open();
        $this->m_query();
        $this->m_getPayments();
        $this->m_close();
    }
}
$Object = new p220;
$Object->m_showResults();
?>