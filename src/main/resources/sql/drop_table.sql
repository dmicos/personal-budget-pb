use personal_duget;
drop table transactions_tags;
drop table tag;
drop table transactions;
drop table counterparty;
drop table currency;
drop table subcategory;
drop table category;
DROP DATABASE personal_duget;

DELETE personal_budget.transactions, personal_budget.counterparty
FROM personal_budget.transactions
         INNER JOIN personal_budget.counterparty ON transactions.counterparty_id=personal_budget.counterparty.id
WHERE personal_budget.counterparty.name  like 'HAIDAICH%';


UPDATE personal_budget.transactions SET amount_transaction = -FLOOR(RAND()*(100+5+1)-55);
