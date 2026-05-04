#ifndef CALC_TREE_H
#define CALC_TREE_H

#include <memory>
#include <string>

//FIX_ME: отсутствовала библиотека iostream.
#include <iostream>

/*
FIX_ME: имена переменных должны соответствовать
стилю lower_case_with_underscores.

const int ADD = -1;
const int SUB = -2;
const int MUL = -3;
const int DIV = -4;
const int MOD = -5;
const int POW = -6;
*/
const int add = -1;
const int sub = -2;
const int mul = -3;
const int div_ = -4;
const int mod = -5;
const int pow_ = -6;

struct TreeNode {
  int value;
  std::shared_ptr<TreeNode> left;
  std::shared_ptr<TreeNode> right;

  TreeNode(int val) : value(val), left(nullptr), right(nullptr) {}
};

class CalcTree {
private:

  std::shared_ptr<TreeNode> root;
  int evaluate(const std::shared_ptr<TreeNode>& node);
  /*
  FIX_ME: имена функций должны соответствовать
  стилю lower_case_with_underscores.

  std::shared_ptr<TreeNode> buildTree(const std::string& expr, size_t& pos);
  void replacePower(std::shared_ptr<TreeNode>& node);
  */
  std::shared_ptr<TreeNode> build_tree(const std::string& expr, size_t& pos);
  void replace_power(std::shared_ptr<TreeNode>& node);

public:

  CalcTree() : root(nullptr) {}

  void transform();
  /*
  FIX_ME: имена функций должны соответствовать
  стилю lower_case_with_underscores.

  void buildFromString(const std::string& expression);
  std::shared_ptr<TreeNode> getRoot() const { return root; }
  */
  void build_from_string(const std::string& expression);
  std::shared_ptr<TreeNode> get_root() const { return root; }

  /*
  FIX_ME: функции для вывода дерева и декодирования операций
  вместо printTree и print.

  void print(std::ostream& os = std::cout);
  void printTree(const std::shared_ptr<TreeNode>& node, int level, std::ostream& os);
  */
  void print_tree(const std::shared_ptr<TreeNode>& node);
  char decode_op(int val);

  //FIX_ME: функция для вывода результата.
  int evaluate();
};

#endif
