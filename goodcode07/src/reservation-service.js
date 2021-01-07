const reservations = [
    {
        date: '2022-10-10',
        start_time: 1000,
        end_time: 1100,
        count: 2,
        limit: 2,
    },
    {
        date: '2022-10-10',
        start_time: 1100,
        end_time: 1200,
        count: 0,
        limit: 2,
    },
    {
        date: '2022-10-11',
        start_time: 1000,
        end_time: 1100,
        count: 1,
        limit: 2,
    },
];

const getReservations = () => {
    return reservations;
};

module.exports = {
    getReservations,
};