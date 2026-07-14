<?php
class p444{
    var $a_cases,$a_queryType,$a_movieArray,$a_title;
    function m_getCases(){$this->a_cases=trim(fgets(STDIN));}
    function m_getData(){
        $this->a_movieArray=explode(" ",trim(fgets(STDIN)),2);
        $this->a_queryType=$this->a_movieArray[0];
        $this->a_title=$this->a_movieArray[1];

    }
    function m_consumeAPI($queryType, $query) {
        $url = "http://www.omdbapi.com/?apikey=a9c305a9&";

        if ($queryType == 't') {
            $url .= "t=" . urlencode($query);
        } else if ($queryType == 's') {
            $url .= "s=" . urlencode($query);
        }

        $v_client = curl_init();
        curl_setopt($v_client, CURLOPT_URL, $url);
        curl_setopt($v_client, CURLOPT_RETURNTRANSFER, 1);
        $response = curl_exec($v_client);
        curl_close($v_client);

        return json_decode($response, true);
    }
    function m_processAPI() {
        $results = [];
            $apiResponse = $this->m_consumeAPI($this->a_queryType, $this->a_title);

            if ($this->a_queryType == 't') {
                if (isset($apiResponse['Title']) && isset($apiResponse['Year'])) {
                    $results[] = "{$apiResponse['Title']} {$apiResponse['Year']}";
                } else {
                    $results[] = "No Match Picture";
                }
            } else if ($this->a_queryType == 's') {
                if (isset($apiResponse['Search'])) {
                    $movies = [];
                    foreach ($apiResponse['Search'] as $movie) {
                        if (isset($movie['Title']) && isset($movie['Year'])) {
                            $movies[] = "{$movie['Title']} {$movie['Year']}";
                        }
                    }
                    if (empty($movies)) {
                        $results[] = "No Match Picture";
                    } else {
                        usort($movies, function($a, $b) {
                            list($titleA, $yearA) = explode(" ", $a, strrpos($a, " "));
                            list($titleB, $yearB) = explode(" ", $b, strrpos($b, " "));
                            $yearA = intval($yearA);
                            $yearB = intval($yearB);
                            if ($yearA == $yearB) {
                                return strcmp($titleA, $titleB);
                            }
                            return $yearA - $yearB;
                        });
                        $results[] = implode("\n", $movies);
                    }
                } else {
                    $results[] = "No Match Picture";
                }
            }
        return implode("\n******\n", $results);
    }
    function m_showResults(){
        $this->m_getCases();
        for($v_meter=0;$v_meter<$this->a_cases;$v_meter++){
            $this->m_getData();
            echo $this->m_processAPI();
        }

    }
}
$Object=new p444();
$Object->m_showResults();
/*
function fetchFromOMDb($queryType, $query, $apiKey) {
    $url = "http://www.omdbapi.com/?apikey=$apiKey&";

    if ($queryType == 't') {
        $url .= "t=" . urlencode($query);
    } else if ($queryType == 's') {
        $url .= "s=" . urlencode($query);
    }

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    $response = curl_exec($ch);
    curl_close($ch);

    return json_decode($response, true);
}

function processInput($input, $apiKey) {
    $lines = explode("\n", trim($input));
    $numberOfQueries = intval(array_shift($lines));

    $results = [];

    for ($i = 0; $i < $numberOfQueries; $i++) {
        $line = $lines[$i];
        list($queryType, $query) = explode(" ", $line, 2);

        $apiResponse = fetchFromOMDb($queryType, $query, $apiKey);

        if ($queryType == 't') {
            if (isset($apiResponse['Title']) && isset($apiResponse['Year'])) {
                $results[] = "{$apiResponse['Title']} {$apiResponse['Year']}";
            } else {
                $results[] = "No Match Picture";
            }
        } else if ($queryType == 's') {
            if (isset($apiResponse['Search'])) {
                $movies = [];
                foreach ($apiResponse['Search'] as $movie) {
                    if (isset($movie['Title']) && isset($movie['Year'])) {
                        $movies[] = "{$movie['Title']} {$movie['Year']}";
                    }
                }
                if (empty($movies)) {
                    $results[] = "No Match Picture";
                } else {
                    usort($movies, function($a, $b) {
                        list($titleA, $yearA) = explode(" ", $a, strrpos($a, " "));
                        list($titleB, $yearB) = explode(" ", $b, strrpos($b, " "));
                        $yearA = intval($yearA);
                        $yearB = intval($yearB);
                        if ($yearA == $yearB) {
                            return strcmp($titleA, $titleB);
                        }
                        return $yearA - $yearB;
                    });
                    $results[] = implode("\n", $movies);
                }
            } else {
                $results[] = "No Match Picture";
            }
        }
    }

    return implode("\n******\n", $results);
}

// Entrada de ejemplo
$input = "2\nt Batman\ns green giant";
$apiKey = "a9c305a9";

echo processInput($input, $apiKey);
*/
?>
