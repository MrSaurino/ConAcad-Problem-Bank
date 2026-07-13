<?php
class p177{
    var $a_cases, $a_email;
    function m_getCases(){$this->a_cases=trim(fgets(STDIN));}
    function m_getEmail(){$this->a_email=trim(fgets(STDIN));}
    function m_validEmail($p_email){
        $v_emailArray=explode('@', $p_email,2);
        $v_user=$v_emailArray[0];
        if(!empty($v_emailArray[1]))
        $v_domain=$v_emailArray[1];

        if (empty($v_user) || strpos($v_user, "..")!==false|| strpos($v_user," ")!==false)
            return "USUARIO INCORRECTO";

        if(empty($v_domain)||strpos($v_domain,"@")!==false|| strpos($v_domain, "..")!==false||!preg_match('/^[a-zA-Z0-9.-]+$/', $v_domain)|| strpos($v_domain," ")!==false)
            return "DOMINIO INCORRECTO";

        return $v_domain;
    }
    function m_getResults(){
        $this->m_getCases();
        for($v_meter=0;$v_meter<$this->a_cases;$v_meter++){
            $this->m_getEmail();
            echo $this->m_validEmail($this->a_email).PHP_EOL;
        }
    }

}
$Object=new p177();
$Object->m_getResults();
?>