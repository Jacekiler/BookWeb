CREATE TABLE IF NOT EXISTS public.book
(
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name            TEXT NOT NULL,
    author          TEXT NOT NULL,
    genre           TEXT NOT NULL,
    rating_sum      NUMERIC(9,2),
    rating_count    INTEGER DEFAULT 0,
    rating_avg      NUMERIC(9,2)
)