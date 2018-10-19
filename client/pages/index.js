import AppLogo from '~/components/AppLogo.vue'
import SockJS from "sockjs-client";
import * as Stomp from "stompjs";
var stompClient =null


export default {
  components: {
    AppLogo
  },
  data(){

    return {
      title: 'Chat Application',
      self:null,
    }
  },
  created:function(){



  },
  computed: {
    messages () { return this.$store.state.message.list }
  },
  methods:{
    connect(id){
      this.self = id
      console.log("connected as user :"+this.self)
      const socket = new SockJS('http://localhost:8080/ws');
      stompClient = Stomp.over(socket);
      stompClient.connect({},  (frame)=> {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/chat/user/'+id,  (greeting) =>{
          let message =JSON.parse(greeting.body)
          this.$store.commit('message/addMessage',{sender:message.sender,receiver:message.receiver,text:message.text})
        });
      });
    },
    sendMessage (e) {
      let receiver
      if(this.self==1){
        receiver = 2
      }else{
        receiver = 1
      }
      stompClient.send("/chat/user/"+receiver, {}, JSON.stringify({'text': e.target.value,'sender':this.self,'receiver':receiver}));
      this.$store.commit('message/addMessage',{sender:this.self,receiver:receiver,text:e.target.value})
      e.target.value = ''
    },

  }
}
