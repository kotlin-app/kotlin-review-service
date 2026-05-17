CREATE TABLE IF NOT EXISTS reviews (
    id         BIGSERIAL PRIMARY KEY,
    product_id BIGINT       NOT NULL,
    user_name  VARCHAR(100) NOT NULL,
    rating     INT          NOT NULL CHECK (rating BETWEEN 1 AND 5),
    comment    TEXT
);
