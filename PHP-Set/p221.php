<?php
class p221{
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
        $v_query="select s.Nombre, count(f.id) as facturas, COALESCE(ROUND(SUM(f.Monto), 2), 0) as monto
                  from BD_PagoServ_Servicios s left join BD_PagoServ_Facturas f on s.id = f.id_servicio and f.fecha_Pago <= f.fecha_Vencimiento
                  and f.fecha_pago !='0000-00-00'
                  group by s.Nombre order by s.Nombre, monto;";
        $this->a_queryResult=mysqli_query($this->a_conection,$v_query);
    }
    function m_getServices(){
        while($v_row=mysqli_fetch_array($this->a_queryResult))
            echo $v_row[0].":".$v_row[1].":$".$v_row[2].PHP_EOL;
    }
    function m_showResults(){
        $this->m_getData();
        $this->m_open();
        $this->m_query();
        $this->m_getServices();
        $this->m_close();
    }
    function m_close(){mysqli_close($this->a_conection);}
}
$Object=new p221;
$Object->m_showResults();
?>