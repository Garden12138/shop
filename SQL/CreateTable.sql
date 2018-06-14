USE web_shop;
-- 测试表
DROP TABLE IF EXISTS tb_test;
CREATE TABLE tb_test(
    f_id VARCHAR(32) PRIMARY KEY,  -- 测试记录id
    f_message VARCHAR(32)          -- 测试信息
);

-- 商品类型表
DROP TABLE IF EXISTS tb_goods_type;
CREATE TABLE tb_goods_type(
    f_id VARCHAR(32) PRIMARY KEY,    -- 商品类型id
    f_name VARCHAR(255),             -- 商品类型名称
    f_code VARCHAR(255) UNIQUE,      -- 商品类型代码
    f_remark VARCHAR(255)            -- 商品类型标签
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 商品表
DROP TABLE IF EXISTS tb_goods;
CREATE TABLE tb_goods(
    f_id VARCHAR(32) PRIMARY KEY,    -- 商品id
    f_title VARCHAR(255),            -- 商品标题
    f_description VARCHAR(255),      -- 商品描述
    f_price DOUBLE,                  -- 商品单价
    f_discount DOUBLE,               -- 商品折扣
    f_locality VARCHAR(255),         -- 生产地
    f_createDate DATETIME,           -- 生成日期
    f_supplier VARCHAR(255),         -- 供应商
    f_putAwayDate DATETIME,          -- 上架日期
    f_storage INT,                   -- 存货量
    f_is_remove INT(1),              -- 是否下架 
    f_image VARCHAR(255),            -- 商品图片存放路径
    f_goods_type_code VARCHAR(32),        -- 商品类型代码
  CONSTRAINT fk_goods_type FOREIGN KEY(f_goods_type_code) REFERENCES tb_goods_type(f_code) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
