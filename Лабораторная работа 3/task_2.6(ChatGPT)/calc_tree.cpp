#include "calc_tree.h"

#include <cmath>
#include <iostream>

/*
FIX_ME: long long используется для предотвращения переполнения.

Node::Node(int val) : value(val), left(nullptr), right(nullptr) {}
*/
Node::Node(long long val) : value(val), left(nullptr), right(nullptr) {}

// Преобразование символа операции в код
int op_code(char op) {
  switch (op) {
  case '+': return -1;
  case '-': return -2;
  case '*': return -3;
  case '/': return -4;
  case '%': return -5;
  case '^': return -6;
  }
  return 0;
}

// Построение дерева
Node* build_tree(const std::string& expr, int& pos) {
  if (pos >= expr.size()) return nullptr;

  while (pos < expr.size() && expr[pos] == ' ') pos++;

  char c = expr[pos++];

  if (isdigit(c)) {
    return new Node(c - '0');
  }

  Node* node = new Node(op_code(c));
  node->left = build_tree(expr, pos);
  node->right = build_tree(expr, pos);

  return node;
}

/*
FIX_ME: long long используется для предотвращения переполнения.

int evaluate(Node* root) {
  if (!root) return 0;

  if (root->value >= 0) return root->value;

  int l = evaluate(root->left);
  int r = evaluate(root->right);

  switch (root->value) {
  case -1: return l + r;
  case -2: return l - r;
  case -3: return l * r;
  case -4: return r != 0 ? l / r : 0;
  case -5: return r != 0 ? l % r : 0;
  case -6: return (int)pow(l, r);
  }

  return 0;
}
*/

// Вычисление выражения
long long evaluate(Node* root) {
  if (!root) return 0;

  if (root->value >= 0) return root->value;

  long long l = evaluate(root->left);
  long long r = evaluate(root->right);

  switch (root->value) {
  case -1: return l + r;
  case -2: return l - r;
  case -3: return l * r;
  case -4: return r != 0 ? l / r : 0;
  case -5: return r != 0 ? l % r : 0;

  /*
  FIX_ME: замена pow, так как функция pow работает с типом double.

  case -6: return (int)pow(l, r);
  */
  case -6: {
    long long res = 1;
    for (long long i = 0; i < r; i++) res *= l;
    return res;
  }
  }

  return 0;
}

// Преобразование дерева
Node* transform(Node* root) {
  if (!root) return nullptr;

  root->left = transform(root->left);
  root->right = transform(root->right);

  if (root->value == -6) {
    int val = evaluate(root);

    free_tree(root->left);
    free_tree(root->right);

    root->left = root->right = nullptr;
    root->value = val;
  }

  return root;
}

//FIX_ME: реализация функции вывода дерева.
void print_tree(Node* root) {
  if (!root) return;

  if (root->value >= 0) {
    std::cout << root->value;
  }
  else {
    std::cout << "(";
    print_tree(root->left);
    std::cout << " " << decode_op(root->value) << " ";
    print_tree(root->right);
    std::cout << ")";
  }
}

char decode_op(int val) {
  switch (val) {
  case -1: return '+';
  case -2: return '-';
  case -3: return '*';
  case -4: return '/';
  case -5: return '%';
  case -6: return '^';
  }
  return '?';
}

void free_tree(Node* root) {
  if (!root) return;

  free_tree(root->left);
  free_tree(root->right);
  delete root;
}
