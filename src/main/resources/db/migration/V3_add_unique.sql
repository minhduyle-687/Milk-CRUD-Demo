ALTER TABLE milk_branch
ADD UNIQUE (Milk_branch_name);

ALTER TABLE milk_type
ADD UNIQUE (Milk_type_name);

ALTER TABLE milk
ADD UNIQUE (Milk_name);