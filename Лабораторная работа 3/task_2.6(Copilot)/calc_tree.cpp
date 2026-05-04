#include "calc_tree.h"

#include <fstream>
#include <cmath>
#include <iostream>

CalcTree::CalcTree() : root(nullptr) {}

CalcTree::~CalcTree() {
  free_tree(root);
}

void CalcTree::free_tree(Node* node) {

  /*
  FIX_ME: не фигурных скобок в теле условия if.

  if (!node) return;
  */
  if (!node) {
    return;
  }

  free_tree(node->left);
  free_tree(node->right);
  delete node;
}

Node* CalcTree::parse(std::istream& in) {

  /*
  FIX_ME: разбор через std::string требовал пробелы между токенами.
  Добавлено посимвольное чтение для поддержки формата без пробелов.

  std::string token;
  if (!(in >> token)) return nullptr;

  if (isdigit(token[0])) {
    return new Node(token[0] - '0');
  }

  int code = 0;
  if (token == "+") code = -1;
  else if (token == "-") code = -2;
  else if (token == "*") code = -3;
  else if (token == "/") code = -4;
  else if (token == "%") code = -5;
  else if (token == "^") code = -6;
  */

  char ch;

  /*
  FIX_ME: нет фигурных скобок в теле условия if.

  if (!(in >> ch)) return nullptr;
  */
  if (!(in >> ch)) {
    return nullptr;
  }

  if (isdigit(ch)) {
    return new Node(ch - '0');
  }

  int code = 0;

  /*
  FIX_ME: нет фигурных скобок в теле условия if и else if.

  if (ch == '+') code = -1;
  else if (ch == '-') code = -2;
  else if (ch == '*') code = -3;
  else if (ch == '/') code = -4;
  else if (ch == '%') code = -5;
  else if (ch == '^') code = -6;
  */
  if (ch == '+') {
    code = -1;
  }
  else if (ch == '-') {
    code = -2;
  }
  else if (ch == '*') {
    code = -3;
  }
  else if (ch == '/') {
    code = -4;
  }
  else if (ch == '%') {
    code = -5;
  }
  else if (ch == '^') {
    code = -6;
  }

  Node* node = new Node(code);
  node->left = parse(in);
  node->right = parse(in);
  return node;
}

void CalcTree::load_from_file(const std::string& filename) {
  std::ifstream fin(filename);
  if (!fin) {
    /*
    FIX_ME: ошибка выводилась не через исключения.

    std::cerr << "Ошибка: не удалось открыть файл\n";
    return;
    */
    throw std::runtime_error("Не удалось открыть файл: " + filename);
  }
  root = parse(fin);
}

int CalcTree::eval(Node* node) {

  /*
  FIX_ME: нет фигурных скобок в телах условий if.

  if (!node) return 0;
  if (node->value >= 0) return node->value;
  */
  if (!node) {
    return 0;
  }
  if (node->value >= 0) {
    return node->value;
  }

  int a = eval(node->left);
  int b = eval(node->right);

  switch (node->value) {
  case -1: return a + b;
  case -2: return a - b;
  case -3: return a * b;
  case -4: return b == 0 ? 0 : a / b;
  case -5: return b == 0 ? 0 : a % b;
  case -6: return (int)std::pow(a, b);
  }
  return 0;
}

//FIX_ME: реализация функции вычисления результата.
int CalcTree::evaluate() {
  return eval(root);
}

Node* CalcTree::transform(Node* node) {

  /*
  FIX_ME: нет фигурных скобок в теле условия if.

  if (!node) return nullptr;
  */
  if (!node) {
    return nullptr;
  }

  node->left = transform(node->left);
  node->right = transform(node->right);

  if (node->value == -6) {
    int val = eval(node);
    free_tree(node->left);
    free_tree(node->right);
    node->left = node->right = nullptr;
    node->value = val;
  }

  return node;
}

void CalcTree::transform_tree() {
  root = transform(root);
}

/*
FIX_ME: правильная реализация функции вывода дерева
(дерево выводилось в неправильной форме).

void CalcTree::print(Node* node, int depth) {
  if (!node) return;

  for (int i = 0; i < depth; i++) std::cout << "  ";
  std::cout << node->value << "\n";

  print(node->left, depth + 1);
  print(node->right, depth + 1);
}

void CalcTree::printTree() {
  print(root, 0);
}
*/
void CalcTree::print_tree(Node* root) {

  /*
  FIX_ME: нет фигурных скобок в теле условия if.

  if (!root) return;
  */
  if (!root) {
    return;
  }

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

char CalcTree::decode_op(int val) {
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

Node* CalcTree::get_root() {
  return root;
}