#ifndef CALC_TREE_H
#define CALC_TREE_H

#include <string>

/*
FIX_ME: long long используется для предотвращения переполнения.

struct Node {
  int value;
  Node* left;
  Node* right;

  Node(int val);
};
*/
struct Node {
  long long value;
  Node* left;
  Node* right;

  Node(long long val);
};

/*
FIX_ME: имя функции должно соответствовать стилю lower_case_with_underscores.

Node* buildTree(const std::string& expr, int& pos);
*/
Node* build_tree(const std::string& expr, int& pos);

/*
FIX_ME: long long используется для предотвращения переполнения.

int evaluate(Node* root);
*/
long long evaluate(Node* root);

Node* transform(Node* root);

/*
FIX_ME: имя функции должно соответствовать стилю lower_case_with_underscores.

int opCode(char op);
*/
int op_code(char op);

/*
FIX_ME: имя функции должно соответствовать стилю lower_case_with_underscores.

void freeTree(Node* root);
*/
void free_tree(Node* root);

//FIX_ME: функции для вывода дерева и декодирования операций.
void print_tree(Node* root);
char decode_op(int val);

#endif
