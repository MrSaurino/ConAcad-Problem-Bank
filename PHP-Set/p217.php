<?php
class p217{
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
        $v_query="select nombre_completo, sum(puntos) as total_puntos from(
                    select concat(u.Nombre, ' ', u.Apellidos) as nombre_completo, sum(j.puntos) as puntos
                    from Usuarios u
                    join BD_Domino_Juegos j on u.Usuario = j.id_usuario
                    where j.ganador = u.Usuario
                    group by u.Usuario
                
                    union all
                
                    select concat(u.Nombre, ' ', u.Apellidos) as nombre_completo, sum(j.puntos) as puntos
                    from Usuarios u
                    join BD_Domino_Juegos j on u.Usuario = j.id_invitado
                    where j.ganador = u.Usuario
                    group by u.Usuario) as foo group by nombre_completo order by total_puntos desc limit 1;";
        $this->a_queryResult=mysqli_query($this->a_conection,$v_query);
    }
    function m_getWinner(){
        $v_result=mysqli_fetch_array($this->a_queryResult);
        echo "$v_result[0]"." "."$v_result[1]";
    }
    function m_close(){mysqli_close($this->a_conection);}
    function m_getResults(){
        $this->m_getData();
        $this->m_open();
        $this->m_query();
        $this->m_getWinner();
        $this->m_close();
    }
}
$Object=new p217();
$Object->m_getResults();
?>