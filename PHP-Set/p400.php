<?php
class p400{
    var $a_tableArray, $a_fieldArray,$a_insertsNum,$a_fieldsNum,$a_tableName;
    var $a_fieldName,$a_fieldType, $a_fieldNameArray=[], $a_insertArray=[];
    function m_getTable(){
        $this->a_tableArray=explode(" ",trim(fgets(STDIN)));
        $this->a_tableName=$this->a_tableArray[0];
        $this->a_insertsNum=$this->a_tableArray[1]; 
        $this->a_fieldsNum=$this->a_tableArray[2];
    }
    function m_getFields(){
        $this->a_fieldArray=explode(" ",trim(fgets(STDIN)));
        $this->a_fieldName=$this->a_fieldArray[0];
        $this->a_fieldType=$this->a_fieldArray[1];
    }
    function m_fieldCreation(){
        if($this->a_fieldType === "char" && count($this->a_fieldArray) >= 3)
            echo " char(255) NOT NULL";
        elseif($this->a_fieldType === "char"){
            echo " char(255) NULL";
            $this->a_flag=false;
            }

        if($this->a_fieldType === "int" && count($this->a_fieldArray) >= 3)
            echo " int NOT NULL";
        elseif($this->a_fieldType === "int") {
            echo " int NULL";
            $this->a_flag=false;
        }

        if($this->a_fieldType === "date" && count($this->a_fieldArray) >= 3)
            echo " date NOT NULL";
        elseif($this->a_fieldType === "date") {
            echo " date NULL";
            $this->a_flag=false;
        }
    }
    function m_insert($p_fieldArray){
        if(count($p_fieldArray)>=3)
        switch($p_fieldArray[1]){
            case 'char': $this->m_charType($p_fieldArray); break;
            case 'int':$this->m_intType($p_fieldArray); break;
            case 'date':$this->m_dateType($p_fieldArray); break;
        }
        else
            return "NULL";
    }
    function m_charType($p_fieldArray){
            switch ($p_fieldArray[2]){
                case "nombre":
                    $names = ["Juan", "Ana", "Maria", "Luisa", "Luis", "Pedro", "Angel", "Carla", "Alicia", "Josefina", "Fernando"];
                    return $names[array_rand($names)];
                case "apellido":
                    $lastNames = ["Lopez", "Perez", "Martinez", "Jimenez", "Gutierrez", "Vera", "Ortega", "Castillo", "Mireles", "Frias", "Morales", "Mejia", "Garcia"];
                    return $lastNames[array_rand($lastNames)];
                case "telefono":
                    $areaCode = $p_fieldArray[3];
                    $phoneNumber = $areaCode . " " . rand(100, 999) . " " . rand(10, 99) . " " . rand(10, 99);
                    return $phoneNumber;
            }
        }
    function m_intType($p_fieldArray){return rand($p_fieldArray[2],$p_fieldArray[3]);}
    function m_dateType($p_fieldArray){
        $FI = strtotime($p_fieldArray[2]);
        $FS = strtotime($p_fieldArray[3]);
        $FF = mt_rand($FI, $FS);
        return date("Y-m-d", $FF);
        }

    function m_showResults(){
        $this->m_getTable();
        echo "DROP TABLE IF EXISTS $this->a_tableName;".PHP_EOL;
        echo "CREATE TABLE $this->a_tableName(";
        echo "id int auto_increment, ";
        for($v_meter=0;$v_meter<$this->a_fieldsNum;$v_meter++){
            $this->m_getFields();
            $this->a_fieldNameArray[$v_meter]=$this->a_fieldName;
            echo "$this->a_fieldName";
            $this->m_fieldCreation();
            if($v_meter!=($this->a_fieldsNum-1))
                echo ", ";
            else
                echo ", PRIMARY KEY(id)";
        }
        echo ") AUTO_INCREMENT=1;".PHP_EOL;
        echo "INSERT INTO $this->a_tableName(";
        
    }
}
$Object=new p400();
$Object->m_showResults();
?>