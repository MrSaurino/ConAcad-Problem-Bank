<?php
class p320{
    var $a_server,$a_user,$a_password,$a_database,$a_conection;
    function m_open(){$this->a_conection = mysqli_connect($this->a_server,$this->a_user,$this->a_password,$this->a_database);}
    function m_close(){mysqli_close($this->a_conection);}
    function m_getData(){
        $this->a_server=trim(fgets(STDIN));
        $this->a_user=trim(fgets(STDIN));
        $this->a_password=trim(fgets(STDIN));
        $this->a_database=trim(fgets(STDIN));
    }
    function m_getWinner(){
        $v_query="select concat(u.Nombre,' ',u.Apellidos) as candidato, p.Nombre as partido, count(v.IdVoto) as votos
                  from BD_Elecciones_Voto v left join BD_Elecciones_Partido p on v.IdPartido = p.IdPartido
                  left join BD_Elecciones_Candidato c on p.IdPartido = c.IdPartido left join Usuarios u on c.IdPersona = u.Usuario
                  group by 1,2 order by votos desc;";
        $v_result=mysqli_query($this->a_conection,$v_query);
        $winner=mysqli_fetch_object($v_result);
        $second=mysqli_fetch_object($v_result);
        $difference=$winner->votos-$second->votos;
        echo "<b>$winner->candidato</b> de $winner->partido gano con $difference votos a $second->candidato.".PHP_EOL;
    }
    function m_noVotes(){
        $v_array=array();
        $v_query="select Nombre from BD_Elecciones_Partido p left join BD_Elecciones_Voto v on p.IdPartido = v.IdPartido where v.IdVoto is null;";
        $v_result=mysqli_query($this->a_conection,$v_query);
        while($v_row=mysqli_fetch_assoc($v_result))
            $v_array[]=$v_row['Nombre'];
        echo implode(", ",$v_array)." Sin Votos.".PHP_EOL;
    }
    function m_noParties(){
        $v_array=array();
        $v_query="select Nombre from BD_Elecciones_Partido where IdPartido not in (select distinct IdPartido from BD_Elecciones_Candidato);";
        $v_result=mysqli_query($this->a_conection,$v_query);
        while($v_row=mysqli_fetch_assoc($v_result))
            $v_array[]=$v_row['Nombre'];
        $v_parties=implode(", ",$v_array);
        echo "<i>$v_parties No tenian candidatos.</i>".PHP_EOL;
    }
    function m_totalVotes(){
        $v_votes=array();
        $v_query="select d.Nombre, count(v.IdVoto) as votos
                  from BD_Elecciones_Voto v join BD_Elecciones_Distrito d on v.IdDistrito = d.IdDistrito group by 1 order by d.Nombre;";
        $v_result=mysqli_query($this->a_conection,$v_query);
        while($v_row=mysqli_fetch_object($v_result))
            $v_votes[]="<b>$v_row->Nombre</b>"." "."<u>$v_row->votos</u>";
        echo implode(" : ",$v_votes).PHP_EOL;
    }
    function m_suffrageVotes(){
        $v_query="select d.Nombre, count(*) as votos from BD_Elecciones_Voto v
              join BD_Elecciones_Distrito d on v.IdDistrito = d.IdDistrito
              where v.IdPapeleta not between cast(substring(d.Rango_Papeleta, 1, locate('-', d.Rango_Papeleta) - 1) as signed)
              and cast(substring(d.Rango_Papeleta, locate('-', d.Rango_Papeleta) + 1) as signed) group by 1
              order by v.IdDistrito;";
        $v_result=mysqli_query($this->a_conection,$v_query);
        $contador = 0;
        while($v_row=mysqli_fetch_object($v_result)) {
            if ($contador % 2 == 0)
                $v_votes[] = "<b>$v_row->Nombre $v_row->votos</b>";
            else
                $v_votes[] = "<i>$v_row->Nombre $v_row->votos</i>";
            $contador++;
        }
        echo implode(" : ",$v_votes).PHP_EOL;
    }


    function m_showResults(){
        $this->m_getData();
        $this->m_open();
        $this->m_getWinner();
        $this->m_noVotes();
        $this->m_noParties();
        $this->m_totalVotes();
        $this->m_suffrageVotes();
        $this->m_close();
    }
}
$Object=new p320;
$Object->m_showResults();
?>
