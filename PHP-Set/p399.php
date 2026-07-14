<?php
class p399{
    var $a_conection;
    function m_getDBData(){
        $v_line=trim(fgets(STDIN));
        $v_DBData=explode(" ",$v_line);
        return $v_DBData;
    }
    function m_open($p_DBData){
        $this->a_conection = mysqli_connect($p_DBData[0],$p_DBData[1],$p_DBData[2],$p_DBData[3]);
    }
    function m_printQuantity($p_query){
        $v_result=mysqli_query($this->a_conection,$p_query);
        $v_quantity=mysqli_fetch_array($v_result);
        echo $v_quantity[0].PHP_EOL;
    }
    function m_printList($p_query,$p_column1,$p_column2){
        $v_array=array();
        $v_result= mysqli_query($this->a_conection,$p_query);
        while($v_row=mysqli_fetch_object($v_result)) {
            $v_column1=$v_row->$p_column1;
            $v_column2=$v_row->$p_column2;
            $v_array[] = "$v_column1 $v_column2";
        }
        echo implode(", ",$v_array).PHP_EOL;
    }
    function m_getTendencies($p_tendency){
        $v_query="select t.Nombre as tendencia, g.Nombre as preferencia, count(*) as cantidad
                  from Citas_Gustos gu
                  join Citas_Usuarios u ON gu.Id_Usuario = u.Id
                  join Citas_Tendencia t ON u.Id_Tendencia = t.Id
                  join Citas_Cata_Gustos g ON gu.Id_Gusto = g.Id
                  where t.Nombre like '$p_tendency'
                  group by t.Nombre, g.Nombre
                  order by tendencia,cantidad desc limit 1;";
        $v_array=array();
        $v_result=mysqli_query($this->a_conection,$v_query);
        while($v_row=mysqli_fetch_object($v_result))
            $v_array[]=$v_row->preferencia;
        echo $p_tendency." ".implode(" ",$v_array);
    }
    function m_getMatches(){
        $v_invitedRow = array();
        $v_acceptRow = array();
        $v_users = array();

        $v_query = "SELECT Id_Invita, Id_Acepta FROM Citas_Citas;";
        $v_result = mysqli_query($this->a_conection, $v_query);
        while($v_row = mysqli_fetch_assoc($v_result)) {
            $v_users[] = $v_row;
        }

        foreach ($v_users as $user) {
            $userId = $user['Id_Invita'];
            $v_query = "SELECT Id_Gusto FROM Citas_Gustos WHERE Id_Usuario=$userId;";
            $v_likes = mysqli_query($this->a_conection, $v_query);
            $v_gustos = array();
            while($v_gusto = mysqli_fetch_assoc($v_likes)) {
                $v_gustos[] = $v_gusto['Id_Gusto'];
            }
            $v_invitedRow[$user['Id_Invita']] = $v_gustos;
        }

        foreach ($v_users as $user) {
            $userId = $user['Id_Acepta'];
            $v_query = "SELECT Id_Gusto FROM Citas_Gustos WHERE Id_Usuario=$userId;";
            $v_likes = mysqli_query($this->a_conection, $v_query);
            $v_gustos = array();
            while($v_gusto = mysqli_fetch_assoc($v_likes)) {
                $v_gustos[] = $v_gusto['Id_Gusto'];
            }
            $v_acceptRow[$user['Id_Acepta']] = $v_gustos;
        }

        $this->m_count($v_users, $v_invitedRow, $v_acceptRow);
    }

    function m_count($p_users, $p_invitedArray, $p_acceptArray){
        $v_count = 0;
        foreach ($p_users as $user) {
            $invitedGustos = isset($p_invitedArray[$user['Id_Invita']]) ? $p_invitedArray[$user['Id_Invita']] : array();
            $acceptGustos = isset($p_acceptArray[$user['Id_Acepta']]) ? $p_acceptArray[$user['Id_Acepta']] : array();

            $v_intersect = array_intersect($invitedGustos, $acceptGustos);
            $totalGustos = count($invitedGustos) + count($acceptGustos);

            if (count($v_intersect) >= $totalGustos / 4) {
                $v_count++;
            }
        }
        echo $v_count . PHP_EOL;
    }


    function m_close(){mysqli_close($this->a_conection);}

    function m_showResults(){
        $this->m_open($this->m_getDBData());
        //Correcto
        $this->m_getMatches();
        //Correcto
        $this->m_printQuantity("select count(*) as cantidad from Citas_Usuarios u where u.Id not in(
                                        select distinct Id_Invita from Citas_Citas
                                        union
                                        select distinct Id_Acepta from Citas_Citas);");
        //Correcto
        $this->m_printList("select t.Nombre, count(*) as citas
                                    from Citas_Citas c join Citas_Usuarios u on c.Id_Invita = u.Id or c.Id_Acepta=u.Id
                                    join Citas_Tendencia t on u.Id_Tendencia = t.Id
                                    join Citas_Estatus e on e.Id=c.Id_Estatus
                                    where e.Nombre = 'Hecho' group by 1;","Nombre","citas");
        //Correcto
        $this->m_getTendencies("Bi");
        echo ", ";
        $this->m_getTendencies("Hetero");
        echo ", ";
        $this->m_getTendencies("LGBTIQ");
        echo "\n";
        //Correcto
        $this->m_printQuantity("select count(*) as citas from Citas_Citas c join Citas_Usuarios u1 on c.Id_Invita = u1.Id
                                   join Citas_Usuarios u2 on c.Id_Acepta = u2.Id
                                   join Citas_Tendencia t1 on u1.Id_Tendencia = t1.Id
                                   join Citas_Tendencia t2 on u2.Id_Tendencia = t2.Id
                                   where (t1.Nombre = 'Hetero' and t2.Nombre = 'LGBTIQ')
                                   or (t1.Nombre = 'LGBTIQ' and t2.Nombre = 'Hetero');");
        //Correcto
        $this->m_printQuantity("select count(*) as citas from Citas_Citas where Id_Estatus=2 and Calif1>=6 and calif2>=6;");
        $this->m_close();
    }
}
$Object = new p399;
$Object->m_showResults();
?>