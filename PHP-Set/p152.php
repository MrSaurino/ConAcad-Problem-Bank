<?php
class p152{
    var $a_cases, $a_deliveries, $a_deliveryArray;
    function m_getCases(){$this->a_cases=trim(fgets(STDIN));}
    function m_getDeliveries(){
        $this->a_deliveryArray=explode(" ",trim(fgets(STDIN)));
        $this->a_deliveries=$this->a_deliveryArray[0];
        array_shift($this->a_deliveryArray);
    }
    function m_processDeliveries($p_deliveryArray,$p_numDeliveries){
        $v_carry=0;$v_pills=0;$v_totalDeliveries=0;
        $v_result="";
        for($v_meter=0;$v_meter<$p_numDeliveries;$v_meter++){
            $v_totalDeliveries++;
            $v_pills=$v_pills+$p_deliveryArray[$v_meter];
            if($v_pills>=100){
                $v_carry=$v_pills-100;
                $v_pills=$v_carry;
                $v_result.=$v_totalDeliveries." ";
                $v_totalDeliveries=0;

            }
        }
        echo trim($v_result)."\n";
    }
    function m_showResults(){
        $this->m_getCases();
        for($v_meter=0;$v_meter<$this->a_cases;$v_meter++){
            $this->m_getDeliveries();
            $this->m_processDeliveries($this->a_deliveryArray,$this->a_deliveries);
        }
    }
}
$Object=new p152();
$Object->m_showResults();
?>
