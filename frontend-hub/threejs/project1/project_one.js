function init(colorin, elementid) {
    var box = mkBox(2,2,2);
    var plane = mkPlane();
    var scene = new THREE.Scene();
    scene.add(box);
    scene.add(plane);
    plane.rotation.x = Math.PI/2;
    //this ensures that half of the box is not below the plane 
    box.position.y = box.geometry.parameters.height/2;
    var camera = new THREE.PerspectiveCamera(45, window.innerWidth/window.innerHeight, 1, 1000);
    camera.position.x = 1;
	camera.position.y = 2;
	camera.position.z = 5;

    camera.lookAt(new THREE.Vector3(0, 0, 0));

    var renderer = new THREE.WebGLRenderer();
    renderer.setSize(window.innerWidth, window.innerHeight);
    document.getElementById(elementid).appendChild(renderer.domElement);
    renderer.render(scene, camera);

    function mkBox(width, height, length){
        var geometry = new THREE.BoxGeometry(width, height, length);
        var material = new THREE.MeshBasicMaterial({
            color: colorin
        });
        var mesh = new THREE.Mesh(geometry, material);
        return mesh;

    }
    //this is teh function that constructs a plane 
  //a plane is simply another mesh
  function mkPlane(){
    var geometry = new THREE.PlaneGeometry(5,5);
    var material = new THREE.MeshBasicMaterial({
      color: "#ffffff",
      side: THREE.DoubleSide
    });

    var mesh = new THREE.Mesh(geometry, material);

    return mesh;
  }
    

}

init('#00ff00', 'webgl1');
init('#0000ff', 'webgl2');

