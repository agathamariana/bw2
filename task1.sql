SELECT event_type, value FROM 
	(SELECT event_type, 
		(SELECT TOTAIS.segundo_maior - TOTAIS.primeiro_maior as value FROM   
        	(SELECT
               (SELECT value FROM events WHERE time = 
               		(SELECT MIN(time) FROM events))
             				as primeiro_maior,
					(SELECT VALUE FROM 
                    	(SELECT t.time, t.value, dense_rank() over 
                      (order by t.time) posicao 
                    from events t) as s_maior
                    where posicao = 2) as segundo_maior)
  			 AS TOTAIS ) as value,
     count(*) AS c 
            FROM events
        GROUP BY event_type
HAVING c > 1) as final   
        ORDER BY event_type