#ifndef CALC_TREE_H
#define CALC_TREE_H

#include <string>
#include <iostream>

struct Node {
  int value;
  Node* left;
  Node* right;

  Node(int v) : value(v), left(nullptr), right(nullptr) {}
};

class CalcTree {
private:
  Node* root;

  Node* parse(std::istream& in);
  int eval(Node* node);
  Node* transform(Node* node);

public:
  CalcTree();
  ~CalcTree();

  /*
  FIX_ME: имена функций должны соответствовать стилю lower_case_with_underscores.

  void loadFromFile(const std::string& filename);
  void transformTree();
  Node* getRoot();
  void freeTree(Node* node);
  */
  void load_from_file(const std::string& filename);
  void transform_tree();
  Node* get_root();
  void free_tree(Node* node);

  //FIX_ME: добавлена функция вывода результата вычисления.
  int evaluate();

  //FIX_ME: функции для вывода дерева и декодирования операций.
  void print_tree(Node* root);
  char decode_op(int val);
};

#endif