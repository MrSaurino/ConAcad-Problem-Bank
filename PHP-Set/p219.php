<?php
class p219{
    var $a_server,$a_user,$a_password,$a_database,$a_conection;
    function m_getData(){
        $this->a_server=trim(fgets(STDIN));
        $this->a_user=trim(fgets(STDIN));
        $this->a_password=trim(fgets(STDIN));
        $this->a_database=trim(fgets(STDIN));
    }
    function m_open(){
        $this->a_conection = mysqli_connect($this->a_server,$this->a_user,$this->a_password,$this->a_database);
    }
    function m_getPrimaryKey(){
        $v_primaryName=array();
        $v_query="select COLUMN_NAME as name
                from INFORMATION_SCHEMA.KEY_COLUMN_USAGE 
                where TABLE_SCHEMA = '$this->a_database' and TABLE_NAME = 'BD_PagoServ_Facturas' and CONSTRAINT_NAME = 'PRIMARY';";
        $v_queryResult=mysqli_query($this->a_conection,$v_query);
        while($v_row=mysqli_fetch_array($v_queryResult))
            $v_primaryName[]=$v_row[0];

        for($v_meter=0;$v_meter<count($v_primaryName);$v_meter++) {
            $v_query = "show columns from BD_PagoServ_Facturas where Field = '$v_primaryName[$v_meter]';";
            $v_queryResult = mysqli_query($this->a_conection, $v_query);
            $v_row = mysqli_fetch_array($v_queryResult);
            $v_type = $v_row[1];
            echo "Nombre de llave primaria: ".$v_primaryName[$v_meter]." [$v_type]".PHP_EOL;
        }
    }
    function m_getForeignKeys(){
        $v_query="select k.COLUMN_NAME as name, c.COLUMN_TYPE as type, k.REFERENCED_TABLE_NAME as table_reference, k.REFERENCED_COLUMN_NAME as reference
                  from INFORMATION_SCHEMA.KEY_COLUMN_USAGE k
                  join INFORMATION_SCHEMA.COLUMNS c on c.TABLE_NAME = k.TABLE_NAME and c.COLUMN_NAME = k.COLUMN_NAME
                  where k.TABLE_SCHEMA = '$this->a_database' and k.TABLE_NAME = 'BD_PagoServ_Facturas' and k.REFERENCED_TABLE_NAME IS NOT NULL order by k.COLUMN_NAME;";
        $v_queryResult=mysqli_query($this->a_conection,$v_query);
        echo "Foraneas:".PHP_EOL;
        while($row=mysqli_fetch_array($v_queryResult)){
            echo "Nombre:".$row[0]." <=> Tabla Referenciada:".$row[2]." <=> CampoForaneo:".$row[3]." <=> [$row[1]]".PHP_EOL;
        }

    }
    function m_close(){mysqli_close($this->a_conection);}
    function m_showResults(){
        $this->m_getData();
        $this->m_open();
        $this->m_getPrimaryKey();
        $this->m_getForeignKeys();
        $this->m_close();
    }

}
$Object=new p219();
$Object->m_showResults();
?>