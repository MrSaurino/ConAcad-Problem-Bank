<?php
class p223{
    var $a_conection,$a_allUsers,$a_userArray,$a_dominoCount,$a_dominoArray,$a_serviceCount,$a_serviceArray;
    function m_getDBData(){
        $v_line=trim(fgets(STDIN));
        $v_DBData=explode(" ",$v_line);
        return $v_DBData;
    }
    function m_open($p_DBData){
        $this->a_conection = mysqli_connect($p_DBData[0],$p_DBData[1],$p_DBData[2],$p_DBData[3]);
    }
    function m_getUsers(){
        $this->a_userArray=[];
        $v_query="select Usuario,Nombre,Apellidos from Usuarios order by Apellidos;";
        $this->a_allUsers=mysqli_query($this->a_conection,$v_query);
        while($v_row=mysqli_fetch_assoc($this->a_allUsers))
            $this->a_userArray[]=$v_row;
    }
    function m_getDominoCount(){
        foreach($this->a_userArray as &$user){
            $v_user=$user['Usuario'];
            $v_query="select count(*) as invitaciones
                  from Usuarios u join Juegos j on u.Usuario = j.id_usuario or u.Usuario = j.id_invitado
                  where j.id_estatus = 1 and u.Usuario='$v_user';";
            $this->a_dominoCount=mysqli_query($this->a_conection,$v_query);
            $row = mysqli_fetch_assoc($this->a_dominoCount);
            $user['invitaciones'] = $row['invitaciones'];
        }
    }

    function m_getServicesCount(){
        foreach($this->a_userArray as &$user){
            $v_user=$user['Usuario'];
            $v_query="select count(f.id) as facturas  
                  from  Facturas f join Usuarios u on f.id_Cliente = u.Usuario
                  where (f.fecha_Pago <= f.fecha_Vencimiento) and (f.id_FormaPago=2 or f.id_FormaPago=3)
                  and (f.fecha_pago !='0000-00-00') and(u.Usuario='$v_user');";
            $this->a_serviceCount=mysqli_query($this->a_conection,$v_query);
            $row=mysqli_fetch_assoc($this->a_serviceCount);
            $user['facturas'] = $row['facturas'];
        }
    }
    function m_printResults(){
        foreach($this->a_userArray as $row)
            if(!($row['invitaciones']==0&&$row['facturas']==0))
                echo $row['Nombre']." ".$row['Apellidos'].":BD_Servicios[".$row['facturas']."]:BD_Domino[".$row['invitaciones']."]".PHP_EOL;
    }
    function m_showResults(){
        $this->m_open($this->m_getDBData());
        $this->m_getUsers();
        $this->m_getDominoCount();
        $this->m_getServicesCount();
        $this->m_printResults();
        $this->m_close();
    }
    function m_close(){mysqli_close($this->a_conection);}
}
$Object=new p223;
$Object->m_showResults();
?>