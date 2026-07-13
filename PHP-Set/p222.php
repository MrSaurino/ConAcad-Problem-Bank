<?php
class p222{
    var $a_queryResult,$a_conection, $a_user, $a_password;
    function m_getDBData(){
        $v_line=trim(fgets(STDIN));
        $v_DBData=explode(" ",$v_line);
        return $v_DBData;
    }
    function m_open($p_DBData){
        $this->a_conection = mysqli_connect($p_DBData[0],$p_DBData[1],$p_DBData[2],$p_DBData[3]);
    }
    function m_getLine($p_line){
            $v_lineArray = explode(" ", $p_line);
            $this->a_user=$v_lineArray[0];
            $this->a_password=$v_lineArray[1];
    }
    function m_query(){
        $v_query="select u.Usuario, concat(u.Nombre,' ',u.Apellidos) as nombre_completo,f.Ref_Bancaria as tarjeta
                  from BD_PagoServ_Facturas f join Usuarios u on f.id_Cliente = u.Usuario
                  where u.Usuario='$this->a_user' and u.Clave=password('$this->a_password') and length(f.Ref_Bancaria)=16
                  order by tarjeta asc;";
        $this->a_queryResult=mysqli_query($this->a_conection,$v_query);
    }
    function m_processQuery(){
        $v_currentUser="";
        $v_arrayUser=array();
        while($v_row=mysqli_fetch_array($this->a_queryResult)){
            if ($v_currentUser === $v_row[0])
                $v_arrayUser[]=$v_row[2];
            else {
                if (!empty($v_arrayUser))
                    echo implode(":", $v_arrayUser) . PHP_EOL;
                $v_currentUser=$v_row[0];
                $v_arrayUser=array($v_row[0], $v_row[1], $v_row[2]);
            }
        }
        if (!empty($v_arrayUser))
            echo implode(":", $v_arrayUser) . PHP_EOL;
    }
    function m_close(){mysqli_close($this->a_conection);}
    function m_showResults(){
        $this->m_open($this->m_getDBData());
        while($v_line=trim(fgets(STDIN))) {
            $this->m_getLine($v_line);
            $this->m_query();
            $this->m_processQuery();
        }
        $this->m_close();
    }
}
$Object=new p222;
$Object->m_showResults();
?>