<?php
class DatingSystem {
    var $a_connection;

    function m_getDBData() {
        $v_line = trim(fgets(STDIN));
        $v_DBData = explode(" ", $v_line);
        return $v_DBData;
    }

    function m_open($p_DBData) {
        $this->a_connection = mysqli_connect($p_DBData[0], $p_DBData[1], $p_DBData[2], $p_DBData[3]);
        if (!$this->a_connection) {
            die("Connection failed: " . mysqli_connect_error());
        }
    }

    function m_getMatches($percentage) {
        $v_users = array();
        $v_invitedRow = array();
        $v_acceptRow = array();

        $v_query = "SELECT Id_Invita, Id_Acepta FROM Citas_Citas;";
        $v_result = mysqli_query($this->a_connection, $v_query);

        if (!$v_result) {
            die("Query failed: " . mysqli_error($this->a_connection));
        }

        while ($v_row = mysqli_fetch_assoc($v_result)) {
            $v_users[] = $v_row;
        }

        foreach ($v_users as $user) {
            $userId = $user['Id_Invita'];
            $v_query = "SELECT Id_Gusto FROM Citas_Gustos WHERE Id_Usuario=$userId;";
            $v_likes = mysqli_query($this->a_connection, $v_query);

            if (!$v_likes) {
                die("Query failed: " . mysqli_error($this->a_connection));
            }

            if (mysqli_num_rows($v_likes) > 0) {
                $v_invitedRow[] = mysqli_fetch_assoc($v_likes);
            } else {
                $v_invitedRow[] = 0;
            }
        }

        foreach ($v_users as $user) {
            $userId = $user['Id_Acepta'];
            $v_query = "SELECT Id_Gusto FROM Citas_Gustos WHERE Id_Usuario=$userId;";
            $v_likes = mysqli_query($this->a_connection, $v_query);

            if (!$v_likes) {
                die("Query failed: " . mysqli_error($this->a_connection));
            }

            if (mysqli_num_rows($v_likes) > 0) {
                $v_acceptRow[] = mysqli_fetch_assoc($v_likes);
            } else {
                $v_acceptRow[] = 0;
            }
        }

        $this->m_count($v_acceptRow, $v_invitedRow, $percentage);
    }

    function m_count($p_acceptArray, $p_invitedArray, $percentage) {
        $v_count = 0;
        foreach ($p_acceptArray as $accept) {
            foreach ($p_invitedArray as $invited) {
                if (is_array($invited)) {
                    $v_intersect = array_intersect($accept, $invited);
                    $v_likesInvited = count($p_invitedArray);
                    $v_likesAccept = count($p_acceptArray);
                    if (count($v_intersect) >= (min($v_likesAccept, $v_likesInvited) * ($percentage / 100))) {
                        $v_count++;
                    }
                }
            }
        }
        echo $v_count . PHP_EOL;
    }

    function m_close() {
        mysqli_close($this->a_connection);
    }

    function m_showResults() {
        $this->m_open($this->m_getDBData());
        $percentage = trim(fgets(STDIN));
        $this->m_getMatches($percentage);
        $this->m_close();
    }
}

$Object = new DatingSystem();
$Object->m_showResults();
?>
