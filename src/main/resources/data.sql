INSERT INTO reviews (product_id, user_name, rating, comment)
SELECT 1, '田中さん', 5, '朝のコーヒーが格段においしくなりました！'
WHERE NOT EXISTS (SELECT 1 FROM reviews WHERE product_id = 1 AND user_name = '田中さん');

INSERT INTO reviews (product_id, user_name, rating, comment)
SELECT 1, '佐藤さん', 4, '操作が簡単で気に入っています。'
WHERE NOT EXISTS (SELECT 1 FROM reviews WHERE product_id = 1 AND user_name = '佐藤さん');

INSERT INTO reviews (product_id, user_name, rating, comment)
SELECT 1, '鈴木さん', 3, '価格の割には普通かな。'
WHERE NOT EXISTS (SELECT 1 FROM reviews WHERE product_id = 1 AND user_name = '鈴木さん');

INSERT INTO reviews (product_id, user_name, rating, comment)
SELECT 2, '山田さん', 5, '音質が最高です。通勤に欠かせません。'
WHERE NOT EXISTS (SELECT 1 FROM reviews WHERE product_id = 2 AND user_name = '山田さん');

INSERT INTO reviews (product_id, user_name, rating, comment)
SELECT 2, '中村さん', 5, 'ノイズキャンセリングが強力で集中できます。'
WHERE NOT EXISTS (SELECT 1 FROM reviews WHERE product_id = 2 AND user_name = '中村さん');

INSERT INTO reviews (product_id, user_name, rating, comment)
SELECT 3, '小林さん', 4, '軽くて持ち運びやすい。保温力も十分です。'
WHERE NOT EXISTS (SELECT 1 FROM reviews WHERE product_id = 3 AND user_name = '小林さん');
