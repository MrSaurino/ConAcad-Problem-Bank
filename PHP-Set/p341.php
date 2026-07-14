<?php
class baseDatos{
    var $a_conexion;
    var $a_servidor;
    var $a_user;
    var $a_password;
    var $a_baseDatos;
    var $a_bloqReg;
    var $a_numReg;
    function __construct($p_DBData) {
        $this->a_servidor = $p_DBData[0];
        $this->a_user = $p_DBData[1];
        $this->a_password = $p_DBData[2];
        $this->a_baseDatos = $p_DBData[3];
    }
    function open(){
        $this->a_conexion = mysqli_connect($this->a_servidor,$this->a_user,$this->a_password,$this->a_baseDatos);
    }
    function close(){
        mysqli_close($this->a_conexion);
    }
    function query($p_query){
        $this->open();
        $this->a_bloqReg=mysqli_query($this->a_conexion,$p_query);
        $this->close();
    }
    function getRecord($p_query){
        $this->open();
        $this->a_bloqReg=mysqli_query($this->a_conexion,$p_query);
        $this->a_numReg=mysqli_num_rows($this->a_bloqReg);
        $this->close();
        return mysqli_fetch_object($this->a_bloqReg);
    }

}
class p341 extends baseDatos {
    var $a_conection,$oBD;
    function __construct() {
        $this->oBD = null;
    }
    function m_getDBData(){
        $v_line=trim(fgets(STDIN));
        $v_DBData=explode(" ",$v_line);
        return $v_DBData;
    }
    function m_open($p_DBData){
        $this->oBD = new baseDatos($p_DBData);
    }
    function m_bestDay(){
        $v_query="select date_format(Fecha, '%d/%b/%Y') as fecha, sum(Apuesta) as dinero 
                  from bd_apuesta group by 1 order by dinero desc limit 1;";
        $v_result=mysqli_query($this->a_conection,$v_query);
        $v_object=mysqli_fetch_object($v_result);
        $fecha=$v_object->fecha;
        $meses = array(
            'Jan' => 'Ene', 'Feb' => 'Feb', 'Mar' => 'Mar', 'Apr' => 'Abr', 'May' => 'May',
            'Jun' => 'Jun', 'Jul' => 'Jul', 'Aug' => 'Ago', 'Sep' => 'Sep', 'Oct' => 'Oct',
            'Nov' => 'Nov', 'Dec' => 'Dic'
        );
        $month = substr($fecha, 3, 3);
        $mes = $meses[$month];
        $v_date=str_replace($month, $mes, $fecha);
        $v_money='$'.number_format($v_object->dinero, 2);
        echo "$v_date $v_money".PHP_EOL;
    }
    function m_biggerBet(){
        $v_query="select max(ba.Apuesta) as apuesta, 
                      CONCAT(ur.Nombre, ' ', ur.Apellidos) as Retador,
                      CONCAT(ui.Nombre, ' ', ui.Apellidos) as Invitado,
                      CONCAT(ug.Nombre, ' ', ug.Apellidos) as Ganador
                  from bd_apuesta ba left join Usuarios ur on ba.Retador = ur.Usuario
                  left join Usuarios ui on ba.Invitado = ui.Usuario
                  left join Usuarios ug on ba.IdGanador = ug.Usuario;";
        $v_result=mysqli_query($this->a_conection,$v_query);
        $v_object=mysqli_fetch_object($v_result);
        echo mb_strtoupper($v_object->Retador)." vs ".mb_strtoupper($v_object->Invitado)." gano ".mb_strtoupper($v_object->Ganador).PHP_EOL;
    }
    function m_getUtilities(){
        $v_query="select sum(Apuesta * 0.1) as ganancias from bd_apuesta;";
        $v_result=mysqli_query($this->a_conection,$v_query);
        $v_money=mysqli_fetch_array($v_result);
        echo '$'.number_format($v_money[0], 2).PHP_EOL;
    }
    function m_moneyWeekends(){
        $v_query="select sum(Apuesta) as dinero from bd_apuesta
                  where dayofweek(Fecha) = 1 or dayofweek(Fecha) = 7;";
        $v_result=mysqli_query($this->a_conection,$v_query);
        $v_money=mysqli_fetch_array($v_result);
        echo '$'.number_format($v_money[0], 2).PHP_EOL;
    }
    function m_badBanks(){
        $v_array=array();
        $v_query="select c.Id, b.Banco, concat(u.Nombre, ' ', u.Apellidos) AS nombre, c.CLABE, length(c.CLABE) as longitud
                  from cuentas_bancarias c join Bancos b on b.id=c.IdBanco
                  join Usuarios u on u.Usuario = c.IdUser
                  where length(CLABE) != 18 and LENGTH(CLABE) != 16 order by Id;";
        $v_result=mysqli_query($this->a_conection,$v_query);
        while($v_row=mysqli_fetch_object($v_result))
            $v_array[]="$v_row->Id $v_row->Banco $v_row->nombre $v_row->longitud";
        echo implode(" : ",$v_array).PHP_EOL;
    }
    function m_getDebt(){
        $v_query="select CONCAT(u.Nombre, ' ', u.Apellidos) as nombre, b.Banco, c.Saldo
                    from cuentas_bancarias c join Usuarios u on c.IdUser = u.Usuario
                    join Bancos b on c.IdBanco = b.Id
                    where c.IdUser = (
                            select u.Usuario from Usuarios u 
                            join cuentas_bancarias c on u.Usuario = c.IdUser
                            where c.Saldo < 0 
                            group by u.Usuario order by sum(c.Saldo) asc limit 1)
                        and c.Saldo < 0 order by c.Saldo asc;";
        $v_result=mysqli_query($this->a_conection,$v_query);
        $v_debt=0;
        $banks="";
        while($v_row=mysqli_fetch_assoc($v_result)){
            $v_debt+=$v_row['Saldo'];
            $v_user=$v_row['nombre'];
            $banks=$banks." ".$v_row['Banco'];
        }
        echo $v_user.$banks." $".$v_debt.PHP_EOL;
    }
    function m_showResults(){
        $this->m_open($this->m_getDBData());
        $this->m_bestDay();
        echo "asds".PHP_EOL;
        $this->m_biggerBet();
        $this->m_getUtilities();
        $this->m_moneyWeekends();
        $this->m_badBanks();
        $this->m_getDebt();
    }
}
$Object=new p341();
$Object->m_showResults();
?>
