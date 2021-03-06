/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.vulkan;

import javax.annotation.*;

import java.nio.*;

import org.lwjgl.*;
import org.lwjgl.system.*;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.MemoryStack.*;

/**
 * Structure containing parameters of a memory allocation.
 * 
 * <h5>Description</h5>
 * 
 * <p>An instance of the {@link VkMemoryAllocateInfo} structure defines a memory import operation if the {@code pNext} chain contains an instance of one of the following structures:   <b> {@link VkImportMemoryWin32HandleInfoKHR} with non-zero {@code handleType}     value   </b> {@link VkImportMemoryFdInfoKHR} with a non-zero {@code handleType} value   * {@link VkImportMemoryHostPointerInfoEXT} with a non-zero {@code handleType}     value</p>
 * 
 * <p>Importing memory <b>must</b> not modify the content of the memory. Implementations <b>must</b> ensure that importing memory does not enable the importing Vulkan instance to access any memory or resources in other Vulkan instances other than that corresponding to the memory object imported. Implementations <b>must</b> also ensure accessing imported memory which has not been initialized does not allow the importing Vulkan instance to obtain data from the exporting Vulkan instance or vice-versa.</p>
 * 
 * <div style="margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;"><h5>Note</h5>
 * 
 * <p>How exported and imported memory is isolated is left to the implementation, but applications should be aware that such isolation <b>may</b> prevent implementations from placing multiple exportable memory objects in the same physical or virtual page. Hence, applications <b>should</b> avoid creating many small external memory objects whenever possible.</p>
 * </div>
 * 
 * <p>When performing a memory import operation, it is the responsibility of the application to ensure the external handles meet all valid usage requirements. However, implementations <b>must</b> perform sufficient validation of external handles to ensure that the operation results in a valid memory object which will not cause program termination, device loss, queue stalls, or corruption of other resources when used as allowed according to its allocation parameters. If the external handle provided does not meet these requirements, the implementation <b>must</b> fail the memory import operation with the error code {@link VK11#VK_ERROR_INVALID_EXTERNAL_HANDLE ERROR_INVALID_EXTERNAL_HANDLE}.</p>
 * 
 * <h5>Valid Usage</h5>
 * 
 * <ul>
 * <li>{@code allocationSize} <b>must</b> be greater than 0</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkExportMemoryAllocateInfo}, and any of the handle types specified in {@link VkExportMemoryAllocateInfo}{@code ::handleTypes} require a dedicated allocation, as reported by {@link VK11#vkGetPhysicalDeviceImageFormatProperties2 GetPhysicalDeviceImageFormatProperties2} in {@link VkExternalImageFormatProperties}{@code ::externalMemoryProperties}{@code ::externalMemoryFeatures} or {@link VkExternalBufferProperties}{@code ::externalMemoryProperties}{@code ::externalMemoryFeatures}, the {@code pNext} chain must contain an instance of {@link VkMemoryDedicatedAllocateInfo} or {@link VkDedicatedAllocationMemoryAllocateInfoNV} with either its {@code image} or {@code buffer} field set to a value other than {@link VK10#VK_NULL_HANDLE NULL_HANDLE}.</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkExportMemoryAllocateInfo}, it <b>must</b> not contain an instance of {@link VkExportMemoryAllocateInfoNV} or {@link VkExportMemoryWin32HandleInfoNV}.</li>
 * <li>If the {@code pNext} chain contains an instance of {@link VkImportMemoryWin32HandleInfoKHR}, it <b>must</b> not contain an instance of {@link VkImportMemoryWin32HandleInfoNV}.</li>
 * <li>If the parameters define an import operation, the external handle specified was created by the Vulkan API, and the external handle type is {@link KHRExternalMemoryCapabilities#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT_KHR EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT_KHR}, then the values of {@code allocationSize} and {@code memoryTypeIndex} <b>must</b> match those specified when the memory object being imported was created.</li>
 * <li>If the parameters define an import operation and the external handle specified was created by the Vulkan API, the device mask specified by {@link VkMemoryAllocateFlagsInfo} <b>must</b> match that specified when the memory object being imported was allocated.</li>
 * <li>If the parameters define an import operation and the external handle specified was created by the Vulkan API, the list of physical devices that comprise the logical device passed to {@link VK10#vkAllocateMemory AllocateMemory} <b>must</b> match the list of physical devices that comprise the logical device on which the memory was originally allocated.</li>
 * <li>If the parameters define an import operation and the external handle is an NT handle or a global share handle created outside of the Vulkan API, the value of {@code memoryTypeIndex} <b>must</b> be one of those returned by {@link KHRExternalMemoryWin32#vkGetMemoryWin32HandlePropertiesKHR GetMemoryWin32HandlePropertiesKHR}.</li>
 * <li>If the parameters define an import operation, the external handle was created by the Vulkan API, and the external handle type is {@link KHRExternalMemoryCapabilities#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT_KHR} or {@link KHRExternalMemoryCapabilities#VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT_KHR}, then the values of {@code allocationSize} and {@code memoryTypeIndex} <b>must</b> match those specified when the memory object being imported was created.</li>
 * <li>If the parameters define an import operation and the external handle type is {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT}, {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT}, or {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT}, {@code allocationSize} <b>must</b> match the size reported in the memory requirements of the {@code image} or {@code buffer} member of the instance of {@link VkDedicatedAllocationMemoryAllocateInfoNV} included in the {@code pNext} chain.</li>
 * <li>If the parameters define an import operation and the external handle type is {@link VK11#VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT}, {@code allocationSize} <b>must</b> match the size specified when creating the Direct3D 12 heap from which the external handle was extracted.</li>
 * <li>If the parameters define an import operation and the external handle is a POSIX file descriptor created outside of the Vulkan API, the value of {@code memoryTypeIndex} <b>must</b> be one of those returned by {@link KHRExternalMemoryFd#vkGetMemoryFdPropertiesKHR GetMemoryFdPropertiesKHR}.</li>
 * <li>If the protected memory feature is not enabled, the {@link VkMemoryAllocateInfo}{@code ::memoryTypeIndex} <b>must</b> not indicate a memory type that reports {@link VK11#VK_MEMORY_PROPERTY_PROTECTED_BIT MEMORY_PROPERTY_PROTECTED_BIT}.</li>
 * <li>If the parameters define an import operation and the external handle is a host pointer, the value of {@code memoryTypeIndex} <b>must</b> be one of those returned by {@link EXTExternalMemoryHost#vkGetMemoryHostPointerPropertiesEXT GetMemoryHostPointerPropertiesEXT}</li>
 * <li>If the parameters define an import operation and the external handle is a host pointer, {@code allocationSize} <b>must</b> be an integer multiple of {@link VkPhysicalDeviceExternalMemoryHostPropertiesEXT}{@code ::minImportedHostPointerAlignment}</li>
 * </ul>
 * 
 * <h5>Valid Usage (Implicit)</h5>
 * 
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK10#VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO}</li>
 * <li>Each {@code pNext} member of any structure (including this one) in the {@code pNext} chain <b>must</b> be either {@code NULL} or a pointer to a valid instance of {@link VkDedicatedAllocationMemoryAllocateInfoNV}, {@link VkExportMemoryAllocateInfo}, {@link VkExportMemoryAllocateInfoNV}, {@link VkExportMemoryWin32HandleInfoKHR}, {@link VkExportMemoryWin32HandleInfoNV}, {@link VkImportMemoryFdInfoKHR}, {@link VkImportMemoryHostPointerInfoEXT}, {@link VkImportMemoryWin32HandleInfoKHR}, {@link VkImportMemoryWin32HandleInfoNV}, {@link VkMemoryAllocateFlagsInfo}, or {@link VkMemoryDedicatedAllocateInfo}</li>
 * <li>Each {@code sType} member in the {@code pNext} chain <b>must</b> be unique</li>
 * </ul>
 * 
 * <h5>See Also</h5>
 * 
 * <p>{@link VK10#vkAllocateMemory AllocateMemory}</p>
 * 
 * <h3>Member documentation</h3>
 * 
 * <ul>
 * <li>{@code sType} &ndash; the type of this structure.</li>
 * <li>{@code pNext} &ndash; {@code NULL} or a pointer to an extension-specific structure.</li>
 * <li>{@code allocationSize} &ndash; the size of the allocation in bytes</li>
 * <li>{@code memoryTypeIndex} &ndash; an index identifying a memory type from the {@code memoryTypes} array of the {@link VkPhysicalDeviceMemoryProperties} structure</li>
 * </ul>
 * 
 * <h3>Layout</h3>
 * 
 * <pre><code>
 * struct VkMemoryAllocateInfo {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkDeviceSize allocationSize;
 *     uint32_t memoryTypeIndex;
 * }</code></pre>
 */
public class VkMemoryAllocateInfo extends Struct implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        STYPE,
        PNEXT,
        ALLOCATIONSIZE,
        MEMORYTYPEINDEX;

    static {
        Layout layout = __struct(
            __member(4),
            __member(POINTER_SIZE),
            __member(8),
            __member(4)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        STYPE = layout.offsetof(0);
        PNEXT = layout.offsetof(1);
        ALLOCATIONSIZE = layout.offsetof(2);
        MEMORYTYPEINDEX = layout.offsetof(3);
    }

    VkMemoryAllocateInfo(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    /**
     * Creates a {@link VkMemoryAllocateInfo} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public VkMemoryAllocateInfo(ByteBuffer container) {
        this(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** Returns the value of the {@code sType} field. */
    @NativeType("VkStructureType")
    public int sType() { return nsType(address()); }
    /** Returns the value of the {@code pNext} field. */
    @NativeType("void const *")
    public long pNext() { return npNext(address()); }
    /** Returns the value of the {@code allocationSize} field. */
    @NativeType("VkDeviceSize")
    public long allocationSize() { return nallocationSize(address()); }
    /** Returns the value of the {@code memoryTypeIndex} field. */
    @NativeType("uint32_t")
    public int memoryTypeIndex() { return nmemoryTypeIndex(address()); }

    /** Sets the specified value to the {@code sType} field. */
    public VkMemoryAllocateInfo sType(@NativeType("VkStructureType") int value) { nsType(address(), value); return this; }
    /** Sets the specified value to the {@code pNext} field. */
    public VkMemoryAllocateInfo pNext(@NativeType("void const *") long value) { npNext(address(), value); return this; }
    /** Sets the specified value to the {@code allocationSize} field. */
    public VkMemoryAllocateInfo allocationSize(@NativeType("VkDeviceSize") long value) { nallocationSize(address(), value); return this; }
    /** Sets the specified value to the {@code memoryTypeIndex} field. */
    public VkMemoryAllocateInfo memoryTypeIndex(@NativeType("uint32_t") int value) { nmemoryTypeIndex(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public VkMemoryAllocateInfo set(
        int sType,
        long pNext,
        long allocationSize,
        int memoryTypeIndex
    ) {
        sType(sType);
        pNext(pNext);
        allocationSize(allocationSize);
        memoryTypeIndex(memoryTypeIndex);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public VkMemoryAllocateInfo set(VkMemoryAllocateInfo src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@link VkMemoryAllocateInfo} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static VkMemoryAllocateInfo malloc() {
        return create(nmemAllocChecked(SIZEOF));
    }

    /** Returns a new {@link VkMemoryAllocateInfo} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static VkMemoryAllocateInfo calloc() {
        return create(nmemCallocChecked(1, SIZEOF));
    }

    /** Returns a new {@link VkMemoryAllocateInfo} instance allocated with {@link BufferUtils}. */
    public static VkMemoryAllocateInfo create() {
        return new VkMemoryAllocateInfo(BufferUtils.createByteBuffer(SIZEOF));
    }

    /** Returns a new {@link VkMemoryAllocateInfo} instance for the specified memory address. */
    public static VkMemoryAllocateInfo create(long address) {
        return new VkMemoryAllocateInfo(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static VkMemoryAllocateInfo createSafe(long address) {
        return address == NULL ? null : create(address);
    }

    /**
     * Returns a new {@link VkMemoryAllocateInfo.Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkMemoryAllocateInfo.Buffer malloc(int capacity) {
        return create(__malloc(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkMemoryAllocateInfo.Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkMemoryAllocateInfo.Buffer calloc(int capacity) {
        return create(nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkMemoryAllocateInfo.Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static VkMemoryAllocateInfo.Buffer create(int capacity) {
        return new Buffer(__create(capacity, SIZEOF));
    }

    /**
     * Create a {@link VkMemoryAllocateInfo.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static VkMemoryAllocateInfo.Buffer create(long address, int capacity) {
        return new Buffer(address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static VkMemoryAllocateInfo.Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : create(address, capacity);
    }

    // -----------------------------------

    /** Returns a new {@link VkMemoryAllocateInfo} instance allocated on the thread-local {@link MemoryStack}. */
    public static VkMemoryAllocateInfo mallocStack() {
        return mallocStack(stackGet());
    }

    /** Returns a new {@link VkMemoryAllocateInfo} instance allocated on the thread-local {@link MemoryStack} and initializes all its bits to zero. */
    public static VkMemoryAllocateInfo callocStack() {
        return callocStack(stackGet());
    }

    /**
     * Returns a new {@link VkMemoryAllocateInfo} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static VkMemoryAllocateInfo mallocStack(MemoryStack stack) {
        return create(stack.nmalloc(ALIGNOF, SIZEOF));
    }

    /**
     * Returns a new {@link VkMemoryAllocateInfo} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static VkMemoryAllocateInfo callocStack(MemoryStack stack) {
        return create(stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    /**
     * Returns a new {@link VkMemoryAllocateInfo.Buffer} instance allocated on the thread-local {@link MemoryStack}.
     *
     * @param capacity the buffer capacity
     */
    public static VkMemoryAllocateInfo.Buffer mallocStack(int capacity) {
        return mallocStack(capacity, stackGet());
    }

    /**
     * Returns a new {@link VkMemoryAllocateInfo.Buffer} instance allocated on the thread-local {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param capacity the buffer capacity
     */
    public static VkMemoryAllocateInfo.Buffer callocStack(int capacity) {
        return callocStack(capacity, stackGet());
    }

    /**
     * Returns a new {@link VkMemoryAllocateInfo.Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkMemoryAllocateInfo.Buffer mallocStack(int capacity, MemoryStack stack) {
        return create(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkMemoryAllocateInfo.Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkMemoryAllocateInfo.Buffer callocStack(int capacity, MemoryStack stack) {
        return create(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #sType}. */
    public static int nsType(long struct) { return memGetInt(struct + VkMemoryAllocateInfo.STYPE); }
    /** Unsafe version of {@link #pNext}. */
    public static long npNext(long struct) { return memGetAddress(struct + VkMemoryAllocateInfo.PNEXT); }
    /** Unsafe version of {@link #allocationSize}. */
    public static long nallocationSize(long struct) { return memGetLong(struct + VkMemoryAllocateInfo.ALLOCATIONSIZE); }
    /** Unsafe version of {@link #memoryTypeIndex}. */
    public static int nmemoryTypeIndex(long struct) { return memGetInt(struct + VkMemoryAllocateInfo.MEMORYTYPEINDEX); }

    /** Unsafe version of {@link #sType(int) sType}. */
    public static void nsType(long struct, int value) { memPutInt(struct + VkMemoryAllocateInfo.STYPE, value); }
    /** Unsafe version of {@link #pNext(long) pNext}. */
    public static void npNext(long struct, long value) { memPutAddress(struct + VkMemoryAllocateInfo.PNEXT, value); }
    /** Unsafe version of {@link #allocationSize(long) allocationSize}. */
    public static void nallocationSize(long struct, long value) { memPutLong(struct + VkMemoryAllocateInfo.ALLOCATIONSIZE, value); }
    /** Unsafe version of {@link #memoryTypeIndex(int) memoryTypeIndex}. */
    public static void nmemoryTypeIndex(long struct, int value) { memPutInt(struct + VkMemoryAllocateInfo.MEMORYTYPEINDEX, value); }

    // -----------------------------------

    /** An array of {@link VkMemoryAllocateInfo} structs. */
    public static class Buffer extends StructBuffer<VkMemoryAllocateInfo, Buffer> implements NativeResource {

        /**
         * Creates a new {@link VkMemoryAllocateInfo.Buffer} instance backed by the specified container.
         *
         * Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link VkMemoryAllocateInfo#SIZEOF}, and its mark will be undefined.
         *
         * <p>The created buffer instance holds a strong reference to the container object.</p>
         */
        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
        }

        public Buffer(long address, int cap) {
            super(address, null, -1, 0, cap, cap);
        }

        Buffer(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            super(address, container, mark, pos, lim, cap);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected Buffer newBufferInstance(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            return new Buffer(address, container, mark, pos, lim, cap);
        }

        @Override
        protected VkMemoryAllocateInfo newInstance(long address) {
            return new VkMemoryAllocateInfo(address, container);
        }

        @Override
        public int sizeof() {
            return SIZEOF;
        }

        /** Returns the value of the {@code sType} field. */
        @NativeType("VkStructureType")
        public int sType() { return VkMemoryAllocateInfo.nsType(address()); }
        /** Returns the value of the {@code pNext} field. */
        @NativeType("void const *")
        public long pNext() { return VkMemoryAllocateInfo.npNext(address()); }
        /** Returns the value of the {@code allocationSize} field. */
        @NativeType("VkDeviceSize")
        public long allocationSize() { return VkMemoryAllocateInfo.nallocationSize(address()); }
        /** Returns the value of the {@code memoryTypeIndex} field. */
        @NativeType("uint32_t")
        public int memoryTypeIndex() { return VkMemoryAllocateInfo.nmemoryTypeIndex(address()); }

        /** Sets the specified value to the {@code sType} field. */
        public VkMemoryAllocateInfo.Buffer sType(@NativeType("VkStructureType") int value) { VkMemoryAllocateInfo.nsType(address(), value); return this; }
        /** Sets the specified value to the {@code pNext} field. */
        public VkMemoryAllocateInfo.Buffer pNext(@NativeType("void const *") long value) { VkMemoryAllocateInfo.npNext(address(), value); return this; }
        /** Sets the specified value to the {@code allocationSize} field. */
        public VkMemoryAllocateInfo.Buffer allocationSize(@NativeType("VkDeviceSize") long value) { VkMemoryAllocateInfo.nallocationSize(address(), value); return this; }
        /** Sets the specified value to the {@code memoryTypeIndex} field. */
        public VkMemoryAllocateInfo.Buffer memoryTypeIndex(@NativeType("uint32_t") int value) { VkMemoryAllocateInfo.nmemoryTypeIndex(address(), value); return this; }

    }

}