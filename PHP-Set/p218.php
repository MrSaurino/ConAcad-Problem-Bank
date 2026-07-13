<?php

class p218{
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
    function m_invites(){
        $v_inviteQuery="select concat(u.Nombre, ' ', u.Apellidos) as nombre_completo, count(*) as invitadas
                        from Usuarios u join BD_Domino_Juegos j on u.Usuario = j.id_usuario
                        group by u.Usuario
                        having invitadas = (select count(*) as invitadas from BD_Domino_Juegos group by id_usuario order by invitadas desc limit 1)
                        order by u.Apellidos asc;";
        $v_queryResult=mysqli_query($this->a_conection,$v_inviteQuery);
        echo "Invita".PHP_EOL;
        while($result = mysqli_fetch_array($v_queryResult))
            echo $result[0].PHP_EOL;
    }
    function m_invited(){
        $v_invitedQuery="select concat(u.Nombre, ' ', u.Apellidos) as nombre_completo, count(*) as invitaciones
                         from Usuarios u join BD_Domino_Juegos j on u.Usuario = j.id_invitado group by u.Usuario
                         having invitaciones = (select count(*) as invitaciones from BD_Domino_Juegos group by id_invitado
    		             order by invitaciones desc limit 1)
                         order by u.Apellidos asc;";
        $v_queryResult=mysqli_query($this->a_conection,$v_invitedQuery);
        echo "Invitado".PHP_EOL;
        while($v_result=mysqli_fetch_array($v_queryResult))
            echo $v_result[0].PHP_EOL;
    }
    function m_close(){mysqli_close($this->a_conection);}
    function m_showResults(){
        $this->m_getData();
        $this->m_open();
        $this->m_invites();
        $this->m_invited();
        $this->m_close();
    }
}
$Object=new p218();
$Object->m_showResults();
?>