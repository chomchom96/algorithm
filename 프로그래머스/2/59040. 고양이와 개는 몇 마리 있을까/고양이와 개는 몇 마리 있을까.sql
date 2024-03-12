SELECT ANIMAL_TYPE, COUNT(animal_id) count FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
HAVING ANIMAL_TYPE = 'Cat' OR ANIMAL_TYPE = 'Dog'
ORDER BY ANIMAL_TYPE ASC