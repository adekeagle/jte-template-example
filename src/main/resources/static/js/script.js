// Funkcja do zmiany statusu zadania (zrobione/niezrobione)
function toggleTaskStatus(taskId) {
       fetch('/toggleTaskStatus/' + taskId, {
           method: 'POST',
       })
       .then(response => response.text())
       .then(data => {
           console.log(data);
           location.reload();  // Opcjonalnie odświeżenie, aby odzwierciedlić zmianę statusu
       })
       .catch(error => console.error('Error:', error));
}