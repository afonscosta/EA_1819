import statisticsService from '../../services/statisticsService'

const state = {
  statistics: {
    g1: '',
    g2: ''
  }
}

const getters = {
  g1: state => {
    return state.statistics.g1
  },
  g2: state => {
    return state.statistics.g2
  }
}

const mutations = {
  setStatistics (state, statistics) {
    state.statistics.g1 = statistics.g1
    state.statistics.g2 = statistics.g2
  }
}

const actions = {
  getStatisticsInfo ({ commit }, payload) {
    statisticsService.fetchStatistics(payload).then(statistics => {
      commit('setStatistics', statistics)
    })
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
