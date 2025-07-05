INSERT INTO roomType (id, description, type) VALUES
(1, 'Standard room with 1 queen bed', 'SINGLE'),
(2, 'Luxury suite with king bed + view', 'SUITE'),
(3, 'Budget room with twin beds', 'ECONOMY'),
(4, 'Family room with 2 double beds', 'FAMILY'),
(5, 'Penthouse with jacuzzi', 'PREMIUM');

INSERT INTO room (id, availableBeds, description, price, roomType_id) VALUES
(1, 1.0000, 'Quiet room near elevator', 99.99, 1),
(2, 1.0000, 'Ocean-view suite', 299.99, 2),
(3, 2.0000, 'Street-facing budget room', 69.50, 3),
(4, 2.0000, 'Spacious room for families', 149.99, 4),
(5, 1.0000, 'Top-floor luxury penthouse', 499.99, 5);