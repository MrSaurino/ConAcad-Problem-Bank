<?php
class p215{
    var $a_server,$a_user,$a_password,$a_database,$a_conection,$a_queryResult;
    function m_open(){$this->a_conection = mysqli_connect($this->a_server,$this->a_user,$this->a_password,$this->a_database);}
    function m_close(){mysqli_close($this->a_conection);}
    function m_getData(){
        $this->a_server=trim(fgets(STDIN));
        $this->a_user=trim(fgets(STDIN));
        $this->a_password=trim(fgets(STDIN));
        $this->a_database=trim(fgets(STDIN));
    }
    function m_getTables($p_query){$this->a_queryResult=mysqli_query($this->a_conection,$p_query);}
    function m_sortTables(){
        $tables = array();
        while($row=mysqli_fetch_array($this->a_queryResult))
            $tables[]=$row[0];
        rsort($tables);
        echo implode(":",$tables);
    }
    function m_showresults(){
        $this->m_getData();
        $this->m_open();
        $this->m_getTables("SHOW TABLES;");
        $this->m_sortTables();
        $this->m_close();
    }
}
$Object=new p215();
$Object->m_showresults();
?>