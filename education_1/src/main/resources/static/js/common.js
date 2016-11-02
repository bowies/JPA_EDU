/**

 * 
 */
var SC_COMMON = (function(){

	if (typeof i18next === 'undefined') {
		$('head').append("<script src='/js/i18n/i18next.js'></script>");
		$('head').append("<script src='/js/i18n/jquery-i18next.min.js'></script>");
		$('head').append("<script src='/js/i18n/i18nextXHRBackend.min.js'></script>");
	}
	
	$.urlParam = function(name){
		var result = new RegExp(name + "=([^&]*)", "i").exec(parent.window.location.search);
		return result && result[1] || "";
	}

	String.prototype.format = function() {
		var s = this;
		for (var i = 0; i <= arguments.length + 1; i++) {       
			var reg = new RegExp("\\{" + i + "\\}", "gm");             
			s = s.replace(reg, arguments[i]);
		}

		return s;
	}	

	if(parent.i18next.inited !== undefined) {
		i18next = parent.i18next;
	}else {
		i18next.initfunc = [];
		i18next.use(i18nextXHRBackend);
		i18next.init({
			lng : 'def',
			debug : true,
			keySeparator : ",",
			backend : {
				loadPath : '/locale/messages.json?locale=' + $.urlParam('locale')
			}
		}, function(err, t) {
			i18next.inited = true;
			for(var i in i18next.initfunc) {
				i18next.initfunc[i]();
			}
			i18next.initfunc = null;
			
		});
	}
	jqueryI18next.init(i18next, $);

	

	// widget string
	pstyle = 'margin: 5px 5px 0 5px;';
	// renderer
	rederDateCurry = function(conumnName) {
		var result = function(record) {
			var srt = record[conumnName];
			if (srt)
				return '<div>' + srt.slice(0, 4) + '-' + srt.slice(4, 6) + '-'
						+ srt.slice(6, 8) + '</div>';
			else
				return '<div> </div>';
		}
		
		return result;		
	}
	renderCodeCurry = function(conumnName, codeMap) {
		return function(record) {
			var data = codeMap.find(function(e) {
				return e.id === record[conumnName];
			});
			if (data)
				return '<div>' + data.text + '</div>';
			else
				return '<div> </div>';
		}
		
	}
	renderProdStatus = function(record) {
		var prodStatusFlg = prodStat.find(function(e) {
			return e.id === record.prodStatusFlg;
		});
		if (prodStatusFlg)
			return '<div>' + prodStatusFlg.text + '</div>';
		else
			return '<div> </div>';
	}
	renderProdDepre = function(record) {
		var prodDepreGbn = deprCode.find(function(e) {
			return e.id + '' === record.prodDepreGbn;
		});
		if (prodDepreGbn)
			return '<div>' + prodDepreGbn.text + '</div>';
		else
			return '<div>  </div>';
	}
	
	

	// Add ECMA262-5 method binding if not supported natively
	//
	if (!('bind' in Function.prototype)) {
	    Function.prototype.bind= function(owner) {
	        var that= this;
	        if (arguments.length<=1) {
	            return function() {
	                return that.apply(owner, arguments);
	            };
	        } else {
	            var args= Array.prototype.slice.call(arguments, 1);
	            return function() {
	                return that.apply(owner, arguments.length===0? args : args.concat(Array.prototype.slice.call(arguments)));
	            };
	        }
	    };
	}

	// Add ECMA262-5 string trim if not supported natively
	//
	if (!('trim' in String.prototype)) {
	    String.prototype.trim= function() {
	        return this.replace(/^\s+/, '').replace(/\s+$/, '');
	    };
	}

	// Add ECMA262-5 Array methods if not supported natively
	//
	if (!('indexOf' in Array.prototype)) {
	    Array.prototype.indexOf= function(find, i /*opt*/) {
	        if (i===undefined) i= 0;
	        if (i<0) i+= this.length;
	        if (i<0) i= 0;
	        for (var n= this.length; i<n; i++)
	            if (i in this && this[i]===find)
	                return i;
	        return -1;
	    };
	}
	if (!('lastIndexOf' in Array.prototype)) {
	    Array.prototype.lastIndexOf= function(find, i /*opt*/) {
	        if (i===undefined) i= this.length-1;
	        if (i<0) i+= this.length;
	        if (i>this.length-1) i= this.length-1;
	        for (i++; i-->0;) /* i++ because from-argument is sadly inclusive */
	            if (i in this && this[i]===find)
	                return i;
	        return -1;
	    };
	}
	if (!('forEach' in Array.prototype)) {
	    Array.prototype.forEach= function(action, that /*opt*/) {
	        for (var i= 0, n= this.length; i<n; i++)
	            if (i in this)
	                action.call(that, this[i], i, this);
	    };
	}
	if (!('map' in Array.prototype)) {
	    Array.prototype.map= function(mapper, that /*opt*/) {
	        var other= new Array(this.length);
	        for (var i= 0, n= this.length; i<n; i++)
	            if (i in this)
	                other[i]= mapper.call(that, this[i], i, this);
	        return other;
	    };
	}
	if (!('filter' in Array.prototype)) {
	    Array.prototype.filter= function(filter, that /*opt*/) {
	        var other= [], v;
	        for (var i=0, n= this.length; i<n; i++)
	            if (i in this && filter.call(that, v= this[i], i, this))
	                other.push(v);
	        return other;
	    };
	}
	if (!('every' in Array.prototype)) {
	    Array.prototype.every= function(tester, that /*opt*/) {
	        for (var i= 0, n= this.length; i<n; i++)
	            if (i in this && !tester.call(that, this[i], i, this))
	                return false;
	        return true;
	    };
	}
	if (!('some' in Array.prototype)) {
	    Array.prototype.some= function(tester, that /*opt*/) {
	        for (var i= 0, n= this.length; i<n; i++)
	            if (i in this && tester.call(that, this[i], i, this))
	                return true;
	        return false;
	    };
	}
	if (!Array.prototype.find) {
		  Object.defineProperty(Array.prototype, "find", {
		    value: function(predicate) {
		      if (this === null) {
		        throw new TypeError('Array.prototype.find called on null or undefined');
		      }
		      if (typeof predicate !== 'function') {
		        throw new TypeError('predicate must be a function');
		      }
		      var list = Object(this);
		      var length = list.length >>> 0;
		      var thisArg = arguments[1];
		      var value;

		      for (var i = 0; i < length; i++) {
		        value = list[i];
		        if (predicate.call(thisArg, value, i, list)) {
		          return value;
		        }
		      }
		      return undefined;
		    }
		  });
		}
})();


var __record = function() {
	var obj = this;
	this.userdefineResolver = function(i){
	    Object.defineProperty(obj, 'userDefines.'+i+'.userColValue', {
	    	  get: function() {
	    		  if(!obj.userDefines) return  "";
	    		  return obj.userDefines[i] == undefined?undefined: obj.userDefines[i].userColValue;
	    	  },
	    	  set: function(value) {
	    		  if(!obj.userDefines) obj.userDefines = {};
	    		  if(obj.userDefines[i] == undefined)
	    			  obj.userDefines[i] = {};	 
	    		  obj.userDefines[i].userColValue = value;	  
	    	  }                	
	    });	
    }	
	this.comboValueResolver = function(name, nameF) {
		Object.defineProperty(obj, nameF, {
	    	  get: function() {
	    		  if(typeof obj[name] === 'undefined') return "";
	    		  var opt = w2ui.prod_popup_form.get(nameF).options;
	    		  if((!opt)||(!opt.items)) return;
	    		  var found = opt.items.find(function(item){ return item.id+'' === obj[name]+''; });
	    		  return !found?"": found.text;
	    	  },
	    	  set: function(value) {
	    		  if(typeof value === 'object') {
	    			  if(!value) 
	    				  obj[name] = "";
	    			  else
	    				  obj[name] = value.id ; 
		    		  return;
	    		  } 
	    		  var opt = w2ui.prod_popup_form.get(nameF).options;
	    		  if((!opt)||(!opt.items)) return;
	    		  var found = opt.items.find(function(item){ return item.text === value; });
	    		  if(!found) 
	    			  obj[name] = ""; 
	    		  else
	    			  obj[name] = found.id ; 
	    	  }                	
	    });	
	}
	this.listValueResolver = function(name, nameF) {
		Object.defineProperty(obj, nameF, {
	    	  get: function() {
	    		  if(typeof obj[name] === 'undefined') return "";
	    		  var opt = w2ui.prod_popup_form.get(nameF).options;
	    		  if((!opt)||(!opt.items)) return;
	    		  var found = opt.items.find(function(item){ return item.id+'' === obj[name]+''; });
	    		  return !found?"":found;
	    	  },
	    	  set: function(value) {
	    		  if(!(value+'')) return;
	    		  obj[name] = value.id ;  
	    	  }                	
	    });	
	}
	this.dateValueResolver = function(name, nameF) {
		
		Object.defineProperty(obj, nameF, {
	    	  get: function() {
	    		  if(typeof obj[name] === 'undefined') return "";
	    		  var srt = obj[name];
	    		  if(!srt) return "";
	    		  return srt.slice(0,4) +'-'+ srt.slice(4,6) +'-'+ srt.slice(6,8);
	    	  },
	    	  set: function(value) {
	    		  if(!(value+'')) return;
	    		  obj[name] = value.replace(/\-/g, '') ;  
	    	  }                	
	    });
	}
	
    
};
	