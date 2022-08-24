# Write your MySQL query statement below
select distinct actor_id , director_id
from ActorDirector as ad
where (
    select count(actor_id)
    from ActorDirector
    where ad.actor_id = actor_id and ad.director_id = director_id
) >=3