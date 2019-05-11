import usersService from "../../services/usersService";

const state = {
  users: []
};

const getters = {
  users: state => {
    return state.users;
  }
};

const mutations = {
  setUsers(state, users) {
    state.users = users;
  },
  addUser(state, user) {
    state.users.push(user);
  },
  updateUser(state, user) {
    state.users = state.users.filter(u => u.id !== user.id);
    state.users.push(user);
  },
  deleteUser(state, userID) {
    state.users = state.users.filter(u => u.id !== userID);
  }
};

const actions = {
  getUsers({ commit }) {
    usersService.fetchUsers().then(users => {
      commit("setUsers", users);
    });
  },
  addUser({ commit }, user) {
    usersService.postUser(user).then(user => {
      commit("addUser", user);
    });
  },
  updateUser({ commit }, user) {
    usersService.postUser(user).then(() => {
      commit("updateUser", user);
    });
  },
  deleteUser({ commit }, userID) {
    usersService.deleteUser(userID);
    commit("deleteUser", userID);
  }
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
};
