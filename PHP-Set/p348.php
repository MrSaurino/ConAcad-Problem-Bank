<?php
class p348{
    function m_getData($p_date){
        $v_url="https://tigger.celaya.tecnm.mx/conacad/recursos/juez/acceConacad.php";
        $v_url.="?fecha=" . urlencode($p_date);
        $v_data=file_get_contents($v_url);
        $v_accessPreg='/<span class="fs-2hx fw-bolder text-dark me-2 lh-1">\s*([\d,]+)<\/span>/';
        $v_genderPreg='/<span class="fw-boldest fs-6 text-dark">\s*(Women|Men|Others)<\/span>\s*<span class="fw-bolder fs-6 text-gray-400">([\d\.]+)%<\/span>/';
        $v_timePreg='/<div class="d-flex fs-6 fw-bold align-items-center[^>]*>\s*<!--begin::Bullet-->\s*<div class="bullet[^>]*>\s*<\/div>\s*<!--end::Bullet-->\s*<!--begin::Label-->\s*<div class="text-gray-500[^>]*>\s*([^<]+)<\/div>\s*<!--end::Label-->\s*<!--begin::Stats-->\s*<div class="fw-boldest text-gray-700 text-xxl-end">([\d,]+)<\/div>\s*<!--end::Stats-->\s*<\/div>/';
        $v_result=$this->m_processData($v_accessPreg,$v_genderPreg,$v_timePreg,$v_data);
        return $v_result;
    }
    function m_processData($p_accessPreg,$p_genderPreg,$p_timePreg,$p_data){
        $v_totalAccess='';
        $v_gender=[];
        $v_time=[];
        if(preg_match($p_accessPreg,$p_data,$v_matches))
            $v_totalAccess=$v_matches[1];
        if(preg_match_all($p_genderPreg,$p_data,$v_matches,PREG_SET_ORDER))
            foreach ($v_matches as $v_match)
                $v_gender[$v_match[1]]=$v_match[2];
        if(preg_match_all($p_timePreg,$p_data,$v_matches,PREG_SET_ORDER))
            foreach($v_matches as $v_match){
                $v_timeZone=trim($v_match[1]);
                $v_access=str_replace(",","",$v_match[2]);
                $v_time[$v_timeZone]=$v_access;
            }
        $v_data=['TotalAccess'=>$v_totalAccess,'Gender'=>$v_gender,"Time"=>$v_time];
        return $v_data;
    }
    function m_getResult($p_date){
            $v_max=-1;
            $v_maxTime="";
            $v_data=$this->m_getData($p_date);
            $v_result=$v_data['TotalAccess']." ";
            foreach($v_data['Gender'] as $v_gender=>$v_percentage)
                if ($v_gender == 'Women')
                    $v_result .= intval(($v_percentage/100) * $v_data['TotalAccess']) . 'M ';
                else if($v_gender == 'Men')
                    $v_result .= intval(($v_percentage/100) * $v_data['TotalAccess']) . 'H ';
                else
                    $v_result .= intval(($v_percentage/100) * $v_data['TotalAccess']) . 'O ';
        $v_meter=0;
        foreach($v_data["Time"] as $v_time=>$v_access) {
            if ($v_access > $v_max && $v_meter >= 2) {
                $v_max = $v_access;
                $v_maxTime = $v_time;
            }
            $v_meter++;
        }
        $v_maxTime=str_replace(" hrs","hrs",$v_maxTime);
        $v_result.=$v_maxTime." ".$v_max;
        echo $v_result.PHP_EOL;
    }
    function m_showResults(){
        while($v_line=trim(fgets(STDIN)))
            $this->m_getResult($v_line);
    }
}
$Object=new p348();
$Object->m_showResults();
?>