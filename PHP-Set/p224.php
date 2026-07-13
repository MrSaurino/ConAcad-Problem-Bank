<?php
class p224{
    var $a_url='https://tigger.celaya.tecnm.mx/conacad/recursos/juez/validPlasticCard.php';
    function m_getCardNumber(){
        $v_cardNumber=trim(fgets(STDIN));
        return $v_cardNumber;
    }
    function m_processCard($p_cardNumber){
        $v_cardSections = http_build_query([
            'one'   => substr($p_cardNumber, 0, 4),
            'two'   => substr($p_cardNumber, 4, 4),
            'tree'  => substr($p_cardNumber, 8, 4),
            'four'  => substr($p_cardNumber, 12, 4),]);
        $v_options = [
            'http' => [
                'method'  => 'POST',
                'header'  => 'Content-type: application/x-www-form-urlencoded',
                'content' => $v_cardSections,],];
        $context  = stream_context_create($v_options);
        $v_web = file_get_contents($this->a_url, false, $context);
        $pattern = '/<div style="text-align: center; margin-top: -100px;" width="100%"><img  src=(.*) ><\/div>/';
        if (preg_match($pattern, $v_web, $matches))
            return $matches[1];
        else
            return  "INCORRECTO";
    }
    function m_getCases($p_type){
        switch($p_type){
            case '"none.png"': return "INCORRECTO".PHP_EOL;
            case '"jcb.png"': return "JCB".PHP_EOL;
            case '"visa.png"': return "VISA".PHP_EOL;
            case '"master.png"': return "MASTER CARD".PHP_EOL;
            case '"amex.png"': return "AMERICAN EXPRESS".PHP_EOL;
            case '"discover.png"': return "DISCOVER".PHP_EOL;
            case '"diners.png"': return "DINERS".PHP_EOL;
            default: return "INCORRECTO".PHP_EOL;
        }
    }
    function m_showResults(){
        while($v_line=$this->m_getCardNumber()){
            $v_type=$this->m_processCard($v_line);
            echo $this->m_getCases($v_type);
        }
    }
}
$Object=new p224;
$Object->m_showResults();
?>