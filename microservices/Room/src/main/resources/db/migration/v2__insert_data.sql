-- Random data insertion for roomType table
INSERT INTO roomType (id, description, type)
VALUES
    (1, 'Single room with single bed', 'Single'),
    (2, 'Double room with queen-size bed', 'Double'),
    (3, 'Luxury suite with separate living room', 'Suite'),
    (4, 'Family room with bunk beds', 'Family'),
    (5, 'Room with accessibility features', 'Accessible'),
    (6, 'Room with sea view', 'Sea View'),
    (7, 'Standard room with two single beds', 'Twin'),
    (8, 'Presidential suite with jacuzzi', 'Presidential'),
    (9, 'Theme room for children', 'Theme'),
    (10, 'Room with private balcony', 'With balcony');

-- Random data insertion for room table
-- Generating 50 rooms with random features
DO $$
DECLARE
    i INTEGER;
    room_type_id INTEGER;
    price_val NUMERIC(38, 2);
    places_val DECIMAL(19,4);
    desc_text VARCHAR(255);
BEGIN
    FOR i IN 1..50 LOOP
        -- Random room type selection (1-10)
        room_type_id := floor(random() * 10) + 1;

        -- Random price between 50 and 500 (in increments of 10)
        price_val := (floor(random() * 46) + 5) * 10;

        -- Random capacity between 1 and 6
        places_val := floor(random() * 6) + 1;

        -- Random description based on room type
        CASE
            WHEN room_type_id = 1 THEN desc_text := 'Comfortable room for one person';
            WHEN room_type_id = 2 THEN desc_text := 'Ideal for couples';
            WHEN room_type_id = 3 THEN desc_text := 'Luxurious space for premium stay';
            WHEN room_type_id = 4 THEN desc_text := 'Perfect for families';
            WHEN room_type_id = 5 THEN desc_text := 'Designed for easy access';
            WHEN room_type_id = 6 THEN desc_text := 'Enjoy the magnificent view';
            WHEN room_type_id = 7 THEN desc_text := 'Two single beds for friends/travelers';
            WHEN room_type_id = 8 THEN desc_text := 'The ultimate in luxury and comfort';
            WHEN room_type_id = 9 THEN desc_text := 'Children will love it';
            WHEN room_type_id = 10 THEN desc_text := 'Private balcony with view';
            ELSE desc_text := 'Comfortable and pleasant room';
        END CASE;

        -- Adding random suffix to description
        CASE floor(random() * 5)
            WHEN 0 THEN desc_text := desc_text || ', air conditioning';
            WHEN 1 THEN desc_text := desc_text || ', mini-bar';
            WHEN 2 THEN desc_text := desc_text || ', flat-screen TV';
            WHEN 3 THEN desc_text := desc_text || ', safe box';
            WHEN 4 THEN desc_text := desc_text || ', high-speed wifi';
        END CASE;

        -- Inserting the room
        INSERT INTO room (id, availablePlaces, description, price, roomType_id)
        VALUES (i, places_val, desc_text, price_val, room_type_id);
    END LOOP;
END $$;

-- Updating sequences to point after inserted IDs
SELECT setval('roomType_seq', (SELECT MAX(id) FROM roomType));
SELECT setval('room_seq', (SELECT MAX(id) FROM room));