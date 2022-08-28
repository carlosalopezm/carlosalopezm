function init(colorin, elementid) {
    var box = mkBox(2,2,2);
    var scene = new THREE.Scene();
    scene.add(box);
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
    

}

init('#00ff00', 'webgl1');
init('#0000ff', 'webgl2');

