// Construtor vazio
function  ToastyPlugin () {}

// A função que passa no trabalho junto aos shells nativos
// Message é uma string, a duração pode ser 'long' ou 'short'
ToastyPlugin . protótipo . show  =  function ( mensagem , duração , successCallback , errorCallback ) {
  var options = {};
  opções . message  = message;
  opções . duração  = duração;
  cordova . exec (successCallback, errorCallback, ' ToastyPlugin ' , ' show ' , [opções]);
}

// Construtor de instalação que liga o ToastyPlugin à janela
ToastyPlugin . install  =  function () {
  if ( ! janela . plugins ) {
    janela . plugins  = {};
  }
  janela . plugins . toastyPlugin  =  novo  ToastyPlugin ();
   janela de retorno . plugins . tostadoPlugin ;
};
cordova . addConstructor ( ToastyPlugin . install );