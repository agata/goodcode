const reservationService = require('./reservation-service');

const reservations = reservationService.getReservations();
console.log('予約情報', reservations);

console.log('<table>');

// 1行目(日付行)の出力
console.log('<tr>');
const dates = [];
for(let i = 0; i < reservations.length; i++) {
  const reservation = reservations[i];

  // 新しい日付が出てきたら1行出力
  if (!dates.includes(reservation.date)) {
    console.log('<td>');
    console.log(reservation.date);
    console.log('</td>');
    dates.push(reservation.date);
  }
}
console.log('</tr>');

// 2行目以降(時間枠の出力)
const times = [];
for(let i = 0; i < reservations.length; i++) {
  const reservation = reservations[i];

  // 新しい時間帯が出てきたら1行出力
  if (!times.includes(reservation.start_time + ':' + reservation.end_time)) {
    console.log('<tr>');
    const dates = [];
    for(let j = 0; j < reservations.length; j++) {
      const reservation2 = reservations[j];

      // 新しい日付が出てきたら1列出力
      if (!dates.includes(reservation2.date)) {
        console.log('<td>');
        for(let k = 0; k < reservations.length; k++) {
          const reservation3 = reservations[k];

          // 時間と日付が一致したら対象の枠なので値を出力する
          if (reservation3.date == reservation2.date
            && (reservation3.start_time + ':' + reservation.end_time) == (reservation.start_time + ':' + reservation.end_time)) {
            console.log(`${reservation3.count}/${reservation3.limit}`);
          }
        }
        console.log('</td>');
        dates.push(reservation.date);
      }      
    }
    console.log('</tr>');
    times.push(reservation.start_time + ':' + reservation.end_time);
  }
}
console.log('</table>');
