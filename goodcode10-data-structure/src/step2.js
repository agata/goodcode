const reservationService = require('./reservation-service');

const reservations = reservationService.getReservations();
console.log('予約情報', reservations);

const buildDays = (reservations) => {
  const uniqueDates = [...new Set(reservations.map((r) => r.date))];
  console.log('uniqueDates', uniqueDates);
  return uniqueDates.map((date) => {
    return {
      date,
    }
  });
};

const buildSlots  = (reservations, days) => {
  const timesMap = new Map();
  reservations.forEach((r) => {
    const key = `${r.start_time}:${r.end_time}`;
    const time = {
      startTime: r.start_time,
      endTime: r.end_time,
    };
    timesMap.set(key, time);
  });
  const uniqueTimes = [...timesMap.values()];
  console.log('uniqueTimes', uniqueTimes);
  return uniqueTimes.map((time) => {
    const targetDays = days.map((day) => {
      const target = reservations.find((r) => r.date == day.date && r.start_time == time.startTime && r.end_time == time.endTime);
      console.log('target', target);
      return {
        date: day.date,
        count: target ? target.count : 0,
        limit: target ? target.limit : 0,
      };
    });
    return {
      time,
      days: targetDays,
    };
  });
};

const buildReservationTable = (reservations) => {
  const days = buildDays(reservations);
  const slots = buildSlots(reservations, days);
  return {
    days,
    slots,
  }
};

const reservationTable = buildReservationTable(reservations);
console.log('reservationTable', JSON.stringify(reservationTable, null, 2));

console.log('<table>');

// 1行目(日付行)の出力
console.log('<tr>');
reservationTable.days.forEach((day) => {
    console.log('<td>');
    console.log(day.date);
    console.log('</td>');
});

// 2行目以降(時間枠の出力)
reservationTable.slots.forEach((slot) => {
    console.log('<tr>');
    slot.days.forEach((day) => {
      console.log('<td>');
      console.log(`${day.count}/${day.limit}`);
      console.log('</td>');
    });
    console.log('</tr>');
});

console.log('</table>');

// const reservationTable = {
//   days: [
//     {
//       date: '2022-10-10'
//     },
//     {
//       date: '2022-10-11'
//     }
//   ],
//   const slots = [
//     {
//       start_time: 1000,
//       end_date: 1100,
//       days: [
//         {
//           date: '2022-10-10'
//           count: 2,
//           limit: 2,
//         },
//         {
//           date: '2022-10-11'
//           count: 1,
//           limit: 2,
//         },
//       ]
//     }
//   ];
// }

